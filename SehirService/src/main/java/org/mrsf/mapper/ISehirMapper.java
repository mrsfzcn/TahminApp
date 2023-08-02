package org.mrsf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mrsf.dto.request.SehirRequestDto;
import org.mrsf.repository.entity.Sehir;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ISehirMapper {

    ISehirMapper INSTANCE= Mappers.getMapper(ISehirMapper.class);

    Sehir toSehir(SehirRequestDto dto);
}
