package com.enaa.backend.Service;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Mappers.TrajetMap;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Repositories.TrajerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajetService {
    private final TrajerRepository trajetRepository;
    private final TrajetMap trajetMap;

    public TrajetService(TrajerRepository trajetRepository, TrajetMap trajetMap) {
        this.trajetRepository = trajetRepository;
        this.trajetMap = trajetMap;
    }

    public TrajetDto ajouterAnnonce(TrajetDto dto){
        Trajet trajet = trajetMap.toEntity(dto);
        Trajet savedTrajet = trajetRepository.save(trajet);
        return trajetMap.toDTO(savedTrajet);
    }
    public List<TrajetDto> getAllTrips(){
        List<Trajet> trajets =trajetRepository.findAll();
        return trajetMap.toDTOs(trajets);
    }


}
