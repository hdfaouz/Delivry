package com.enaa.backend.Service;

import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Mappers.DemandeMap;
import com.enaa.backend.Model.Demande;
import com.enaa.backend.Model.Sender;
import com.enaa.backend.Model.StatutDemand;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Repositories.DemandeRepository;
import com.enaa.backend.Repositories.TrajerRepository;
import com.enaa.backend.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemandeService {

   private  final DemandeRepository demandeRepository;
   private final DemandeMap demandeMap;
   private final UserRepository userRepository;
   private final TrajerRepository trajerRepository;

    public DemandeService(DemandeRepository demandeRepository, DemandeMap demandeMap, UserRepository userRepository, TrajerRepository trajerRepository) {
        this.demandeRepository = demandeRepository;
        this.demandeMap = demandeMap;
        this.userRepository = userRepository;
        this.trajerRepository = trajerRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public DemandeDto ajouterDemande(DemandeDto demandeDto){
        Demande demande = demandeMap.toEntity(demandeDto);

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Sender sender = (Sender) userRepository.findByEmail(email);
        demande.setSender(sender);
        Demande addDemande = demandeRepository.save(demande);
        if (demande.getStatut() == null) {
            demande.setStatut(StatutDemand.EN_ATTENTE);
        }
        return demandeMap.toDto(addDemande);
    }

    public List<DemandeDto> getAllDemande(){
        List<Demande> demandes = demandeRepository.findAll();
        return demandeMap.toDtos(demandes);
    }

    public void deletDemand(Long id){
        demandeRepository.deleteById(id);
    }
}
