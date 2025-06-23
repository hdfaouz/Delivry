package com.enaa.backend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String lieuDepart;
    private String etapeIntermidiaire;
    private String destinationFinal;
    @Column(name = "date_depart", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateDepart;
    @Column(name = "dimension_max")
    private String dimensionMax;
    private String typeMarchandise;
    private Long capaciteDespo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getEtapeIntermidiaire() {
        return etapeIntermidiaire;
    }

    public void setEtapeIntermidiaire(String etapeIntermidiaire) {
        this.etapeIntermidiaire = etapeIntermidiaire;
    }

    public String getDestinationFinal() {
        return destinationFinal;
    }

    public void setDestinationFinal(String destinationFinal) {
        this.destinationFinal = destinationFinal;
    }

    public LocalDate getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(LocalDate dateDepart) {
        this.dateDepart = dateDepart;
    }

    public String getDimensionMax() {
        return dimensionMax;
    }

    public void setDimensionMax(String dimensionMax) {
        this.dimensionMax = dimensionMax;
    }

    public String getTypeMarchandise() {
        return typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }

    public Long getCapaciteDespo() {
        return capaciteDespo;
    }

    public void setCapaciteDespo(Long capaciteDespo) {
        this.capaciteDespo = capaciteDespo;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @ManyToOne
    private Driver driver;

    @OneToMany(mappedBy = "trajet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Demande> requests = new ArrayList<>();
}
