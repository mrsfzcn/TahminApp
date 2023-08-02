package org.mrsf.service;


import org.mrsf.dto.request.SehirRequestDto;
import org.mrsf.exception.ErrorType;
import org.mrsf.exception.SehirServiceException;
import org.mrsf.mapper.ISehirMapper;
import org.mrsf.repository.ISehirRepository;
import org.mrsf.repository.entity.Sehir;
import org.mrsf.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SehirService extends ServiceManager<Sehir, Long> {
    private final ISehirRepository sehirRepository;

    public SehirService(ISehirRepository sehirRepository) {
        super(sehirRepository);
        this.sehirRepository = sehirRepository;
    }

    public Sehir ekle(SehirRequestDto dto) {
        Sehir sehir=ISehirMapper.INSTANCE.toSehir(dto);
        sehir.setBlur(sehir.getIsim().substring(0,2));
        return save(sehir);
    }

    public Sehir sehirGetir(Long id) {
        Optional<Sehir> sehir = findById(id);
        if (sehir.isEmpty()){
            throw new SehirServiceException(ErrorType.SEHIR_NOT_FOUND);

        }
        return sehir.get();
    }
}
