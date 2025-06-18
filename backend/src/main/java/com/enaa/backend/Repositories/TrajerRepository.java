package com.enaa.backend.Repositories;

import com.enaa.backend.Model.Trajet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrajerRepository extends JpaRepository<Trajet,Long> {
    List<Trajet> findByDriver_Id(Long id);
}
