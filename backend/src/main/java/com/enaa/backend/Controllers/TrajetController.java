package com.enaa.backend.Controllers;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Service.TrajetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/trajet")
public class TrajetController {
    private final TrajetService trajetService;

    public TrajetController(TrajetService trajetService) {

        this.trajetService = trajetService;
    }

    @PostMapping
    public TrajetDto ajouterTrajet(@RequestBody TrajetDto dto) {

        return trajetService.ajouterAnnonce(dto);
    }

    @GetMapping
    public List<TrajetDto> afficherTrajets() {

        return trajetService.getAllTrips();
    }


    @DeleteMapping("/{id}")
    public void deleteTrajetById(@PathVariable Long id) {

        trajetService.deleteTrajet(id);
    }
}

