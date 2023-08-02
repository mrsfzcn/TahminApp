package org.mrsf.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.mrsf.dto.response.TahminResponseDto;
import org.mrsf.repository.entity.Tahmin;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITahminMapper {

    ITahminMapper INSTANCE= Mappers.getMapper(ITahminMapper.class);

    TahminResponseDto toTahminResponseDto(Tahmin tahmin);
}
