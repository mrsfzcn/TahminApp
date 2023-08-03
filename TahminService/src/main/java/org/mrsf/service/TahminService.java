package org.mrsf.service;

import org.mrsf.dto.request.TahminRequestDto;
import org.mrsf.dto.response.Sehir;
import org.mrsf.dto.response.TahminResponseDto;
import org.mrsf.exception.ErrorType;
import org.mrsf.exception.TahminServiceException;
import org.mrsf.manager.IKullaniciManager;
import org.mrsf.manager.ISehirManager;
import org.mrsf.mapper.ITahminMapper;
import org.mrsf.rabbitmq.model.SkorModel;
import org.mrsf.rabbitmq.producer.SkorProducer;
import org.mrsf.repository.ITahminRepository;
import org.mrsf.repository.entity.Tahmin;
import org.mrsf.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TahminService extends ServiceManager<Tahmin, Long> {

    private final ITahminRepository tahminRepository;
    private final ISehirManager sehirManager;
    private final IKullaniciManager kullaniciManager;
    private final SkorProducer skorProducer;

    public TahminService(ITahminRepository tahminRepository, ISehirManager sehirManager, IKullaniciManager kullaniciManager, SkorProducer skorProducer) {
        super(tahminRepository);
        this.tahminRepository = tahminRepository;
        this.sehirManager = sehirManager;
        this.kullaniciManager = kullaniciManager;
        this.skorProducer = skorProducer;
    }

    public TahminResponseDto tahminOlustur(Long userId) {

        Sehir sehir = sehirManager.sehirGetir(1L).getBody();
        Tahmin tahmin = Tahmin.builder()
                .userId(userId)
                .dogruCevap(sehir.getIsim())
                .blur(sehir.getBlur())
                .build();
        save(tahmin);
        kullaniciManager.updateAktifTahminId(userId, tahmin.getId());
        return ITahminMapper.INSTANCE.toTahminResponseDto(tahmin);
    }

    public String tahminYap(TahminRequestDto dto) {

        Optional<Tahmin> tahmin = tahminRepository.findById(dto.getTahminId());

        if (tahmin.get().getHak()==0){
            return "Hakkınız bitmiştir.";
        }

        if (tahmin.get().isDogrulandiMi()) {
            throw new TahminServiceException(ErrorType.BAD_REQUEST);
        }

        tahmin.get().getTahminler().add(dto.getTahmin());

        if (tahmin.get().getDogruCevap().equalsIgnoreCase(dto.getTahmin())) {
            tahmin.get().setDogrulandiMi(true);
            update(tahmin.get());
            skorProducer.sendSkor(SkorModel.builder()
                    .skor(10)
                    .userId(dto.getUserId())
                    .build());
        return "Tebrikler Doğru Cevap";
        }

        tahmin.get().setHak(tahmin.get().getHak()-1);
        update(tahmin.get());
        skorProducer.sendSkor(SkorModel.builder()
                        .skor(-5)
                        .userId(dto.getUserId())
                .build());
        return "Yanlış cevap, tekrar deneyiniz."+tahmin.get().getHak()+" hakkınız kalmıştır.";
    }
}
