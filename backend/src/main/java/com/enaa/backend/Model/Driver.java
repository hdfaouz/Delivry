package com.enaa.backend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Driver  extends User{
    @OneToMany(mappedBy = "driver")
    private List<Trajet> annonces;
}
