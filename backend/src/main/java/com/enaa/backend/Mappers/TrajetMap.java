package com.enaa.backend.Mappers;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Model.Driver;
import com.enaa.backend.Model.Trajet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrajetMap {
    @Mapping(source = "dateDepart", target = "dateDepart")
    Trajet toEntity(TrajetDto dto);

    TrajetDto toDTO(Trajet trajet);

    List<TrajetDto> toDTOs(List<Trajet> trips);


}
