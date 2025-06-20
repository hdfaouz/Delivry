package com.enaa.backend.Service;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Mappers.TrajetMap;
import com.enaa.backend.Model.Driver;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Repositories.TrajerRepository;
import com.enaa.backend.Repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajetService {
    private final TrajerRepository trajetRepository;
    private final TrajetMap trajetMap;
    private final UserRepository userRepository;

    public TrajetService(TrajerRepository trajetRepository, TrajetMap trajetMap, UserRepository userRepository) {
        this.trajetRepository = trajetRepository;
        this.trajetMap = trajetMap;
        this.userRepository = userRepository;
    }

    public TrajetDto ajouterAnnonce(TrajetDto dto){
        Trajet trip = trajetMap.toEntity(dto);

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Driver driver = (Driver) userRepository.findByEmail(email);

        trip.setDriver(driver);

        Trajet savedTrip = trajetRepository.save(trip);
        return trajetMap.toDTO(savedTrip);
    }

    public List<TrajetDto> getAllTrips(){
        List<Trajet> trajets =trajetRepository.findAll();
        return trajetMap.toDTOs(trajets);
    }


    public List<TrajetDto> getTrajetByConducteur(Long id){
        List<Trajet> trajets = trajetRepository.findTrajetByDriverId(id);
        return trajetMap.toDTOs(trajets);
    }

    public void deleteTrajet(Long id){

        trajetRepository.deleteById(id);
    }

//    public TrajetDto update(TrajetDto dto, Long id){
//        Trajet foundTrip = trajetRepository.findById(id)
//                .orElseThrow(()-> new RuntimeException("trip not found"));
//        foundTrip.setLieuDepart(dto.getLieuDepart());
//        foundTrip.setEtapeIntermidiaire(dto.getEtapeIntermidiaire());
//        foundTrip.setDestinationFinal(dto.getDestinationFinal());
//        foundTrip.setDateDepart(dto.getDateDepart());
//        foundTrip.setDimensionMax(dto.getDimensionMax());
//        foundTrip.setTypeMarchandise(dto.getTypeMarchandise());
//        foundTrip.setCapaciteDespo(dto.getCapaciteDespo());
//        Trajet trip = trajetRepository.save(foundTrip);
//        return trajetMap.toDTO(trip);
//    }


}
