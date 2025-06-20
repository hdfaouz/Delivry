package com.enaa.backend.Mappers;
import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Model.Demande;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemandeMap {
       Demande toEntity (DemandeDto demandeDto);
        DemandeDto toDto (Demande demande);
        List<DemandeDto> toDtos (List<Demande> demandes);

}
