package org.mrsf.service;

import org.mrsf.dto.response.Sehir;
import org.mrsf.dto.response.TahminResponseDto;
import org.mrsf.manager.ISehirManager;
import org.mrsf.mapper.ITahminMapper;
import org.mrsf.repository.ITahminRepository;
import org.mrsf.repository.entity.Tahmin;
import org.mrsf.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class TahminService extends ServiceManager<Tahmin, Long> {

    private final ITahminRepository tahminRepository;
    private final ISehirManager sehirManager;

    public TahminService(ITahminRepository tahminRepository, ISehirManager sehirManager) {
        super(tahminRepository);
        this.tahminRepository = tahminRepository;
        this.sehirManager = sehirManager;
    }

    public TahminResponseDto tahminOlustur(Long userId) {
        Sehir sehir=sehirManager.sehirGetir(1L).getBody();
        Tahmin tahmin=Tahmin.builder()
                .userId(userId)
                .dogruCevap(sehir.getIsim())
                .blur(sehir.getBlur())
                .build();
        save(tahmin);
        return ITahminMapper.INSTANCE.toTahminResponseDto(tahmin);
    }
}
