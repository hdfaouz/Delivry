package com.enaa.backend.Mappers;
import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Model.Demande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemandeMap {

       @Mapping(target = "trajet.id", source = "idtrajet")
       Demande toEntity (DemandeDto demandeDto);

       @Mapping(source = "trajet.id", target = "idtrajet")
       DemandeDto toDto (Demande demande);


       List<DemandeDto> toDtos (List<Demande> demandes);

}
