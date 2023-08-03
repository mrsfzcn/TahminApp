package org.mrsf.service;

import org.mrsf.dto.request.GirisRequestDto;
import org.mrsf.dto.request.KayitRequestDto;
import org.mrsf.dto.response.KayitResponseDto;
import org.mrsf.exception.ErrorType;
import org.mrsf.exception.KullaniciServiceException;
import org.mrsf.mapper.IKullaniciMapper;
import org.mrsf.repository.IKullaniciRepository;
import org.mrsf.repository.entity.Kullanici;
import org.mrsf.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KullaniciService extends ServiceManager<Kullanici, Long> {
    private final IKullaniciRepository kullaniciRepository;

    public KullaniciService(IKullaniciRepository kullaniciRepository) {
        super(kullaniciRepository);
        this.kullaniciRepository = kullaniciRepository;
    }

    public KayitResponseDto kayit(KayitRequestDto dto) {

        Kullanici kullanici = IKullaniciMapper.INSTANCE.toKullanici(dto);
        save(kullanici);
        return IKullaniciMapper.INSTANCE.toKayitResponseDto(kullanici);
    }
    public Boolean giris(GirisRequestDto dto){
        Optional<Kullanici> kullanici = kullaniciRepository.findByUsernameAndPassword(dto.getUsername(), dto.getPassword());

        if (kullanici.isEmpty()){
            throw new KullaniciServiceException(ErrorType.USER_NOT_FOUND);
        }
        return true;
    }

    public Boolean updateAktifTahminId(Long id, Long tahminId) {
        Optional<Kullanici> kullanici = kullaniciRepository.findById(id);
        if (kullanici.isEmpty()){
            throw new KullaniciServiceException(ErrorType.USER_NOT_FOUND);
        }
        kullanici.get().setAktifTahminId(tahminId);
        kullanici.get().getTahminler().add(tahminId);
        update(kullanici.get());
        return true;
    }
}
