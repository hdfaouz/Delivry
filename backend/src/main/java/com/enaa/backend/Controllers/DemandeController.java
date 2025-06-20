package com.enaa.backend.Controllers;

import com.enaa.backend.Dto.DemandeDto;
import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Service.DemandeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demande")
public class DemandeController {
    private final DemandeService demandeService;

    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping
    public DemandeDto ajouterDemand(@RequestBody DemandeDto demandeDto){
        return demandeService.ajouterDemande(demandeDto);
    }

    @GetMapping
    public List<DemandeDto> afficherTrajets(){
        return demandeService.getAllDemande();
    }

    @DeleteMapping("/{id}")
    public void deletDemandeById(@PathVariable Long id){
        demandeService.deletDemand(id);
    }
    @PutMapping("/{id}")
   public DemandeDto updateDemand(@RequestBody DemandeDto dto, @PathVariable Long id){
       return demandeService.update(dto, id);
   }
}

