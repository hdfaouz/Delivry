package com.enaa.backend.Service;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Mappers.TrajetMap;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Repositories.TrajerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrajetService {
    private final TrajerRepository trajetRepository;
    private final TrajetMap trajetMap;

    public TrajetService(TrajerRepository trajetRepository, TrajetMap trajetMap) {
        this.trajetRepository = trajetRepository;
        this.trajetMap = trajetMap;
    }

    public Trajet createAnnonce(Trajet trajet){
        return trajetRepository.save(trajet);
    }
}
