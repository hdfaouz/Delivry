package com.enaa.backend.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;



@Entity
public class Trajet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String lieuDepart;
    private String etapeIntermidiaire;
    private String destinationFinal;
    @Column(name = "date_depart", nullable = false)
    @JsonFormat(pattern = "d-M-yyyy")
    private LocalDate dateDepart;
    @Column(name = "dimension_max") // Assurez-vous que le nom correspond à votre table
    private String dimensionMax;
    private String typeMarchandise;
    private Long capaciteDespo;

    public Trajet() {
    }

    public Trajet(Long id, String lieuDepart, String etapeIntermidiaire, String destinationFinal, LocalDate dateDepart, String dimensionMax, String typeMarchandise, Long capaciteDespo, Driver driver) {
        this.id = id;
        this.lieuDepart = lieuDepart;
        this.etapeIntermidiaire = etapeIntermidiaire;
        this.destinationFinal = destinationFinal;
        this.dateDepart = dateDepart;
         this.dimensionMax = dimensionMax;
        this.typeMarchandise = typeMarchandise;
        this.capaciteDespo = capaciteDespo;
        this.driver = driver;
    }

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

}
