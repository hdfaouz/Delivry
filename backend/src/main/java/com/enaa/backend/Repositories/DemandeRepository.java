package com.enaa.backend.Repositories;

import com.enaa.backend.Model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandeRepository extends JpaRepository<Demande,Long> {
}
