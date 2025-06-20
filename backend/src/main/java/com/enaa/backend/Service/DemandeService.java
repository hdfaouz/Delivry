package com.enaa.backend.Service;

import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Mappers.DemandeMap;
import com.enaa.backend.Model.Demande;
import com.enaa.backend.Repositories.DemandeRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {

   private  final DemandeRepository demandeRepository;
   private final DemandeMap demandMap;

    public DemandeService(DemandeRepository demandeRepository, DemandeMap demandMap) {
        this.demandeRepository = demandeRepository;
        this.demandMap = demandMap;
    }


    public DemandeDto ajouterDemande(DemandeDto demandeDto){
        Demande demande = demandMap.toEntity(demandeDto);
        Demande saveDeman = demandeRepository.save(demande);
        return demandMap.toDto(saveDeman);
    }
}
