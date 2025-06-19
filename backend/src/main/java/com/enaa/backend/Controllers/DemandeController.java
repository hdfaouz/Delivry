package com.enaa.backend.Controllers;

import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Service.DemandeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demande/")
public class DemandeController {
    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public DemandeDto ajouterDemand(@RequestBody DemandeDto demandeDto){
        return demandeService.ajouterDemande(demandeDto);
    }
}
