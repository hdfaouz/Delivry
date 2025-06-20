package com.enaa.backend.Mappers;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Model.Driver;
import com.enaa.backend.Model.Trajet;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrajetMap {

    Trajet toEntity(TrajetDto dto);

    TrajetDto toDTO(Trajet trajet);
    List<TrajetDto> toDTOs(List<Trajet> trips);


}
