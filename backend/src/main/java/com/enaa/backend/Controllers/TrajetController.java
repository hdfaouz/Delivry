package com.enaa.backend.Controllers;

import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Service.TrajetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trajet")
public class TrajetController {
    private final TrajetService trajetService;

    public TrajetController(TrajetService trajetService) {
        this.trajetService = trajetService;
    }

    @PostMapping
    public TrajetDto ajouterTrajet(@RequestBody TrajetDto dto){
        return trajetService.ajouterAnnonce(dto);
    }
}
