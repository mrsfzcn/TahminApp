package org.mrsf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mrsf.dto.request.KayitRequestDto;
import org.mrsf.dto.response.KayitResponseDto;
import org.mrsf.repository.entity.Kullanici;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IKullaniciMapper {

    IKullaniciMapper INSTANCE= Mappers.getMapper(IKullaniciMapper.class);

    Kullanici toKullanici(KayitRequestDto dto);

    KayitResponseDto toKayitResponseDto(Kullanici kullanici);
}
