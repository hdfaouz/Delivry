package com.enaa.backend.Service;

import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Mappers.DemandMap;
import com.enaa.backend.Model.Demande;
import com.enaa.backend.Repositories.DemandeRepository;
import org.springframework.stereotype.Service;

@Service
public class DemandeService {

   private  final DemandeRepository demandeRepository;
   private final DemandMap demandMap;

    public DemandeService(DemandeRepository demandeRepository, DemandMap demandMap) {
        this.demandeRepository = demandeRepository;
        this.demandMap = demandMap;
    }


    public DemandeDto ajouterDemande(DemandeDto demandeDto){
        Demande demande = demandMap.toEntity(demandeDto);
        Demande saveDeman = demandeRepository.save(demande);
        return demandMap.toDto(saveDeman);
    }
}
