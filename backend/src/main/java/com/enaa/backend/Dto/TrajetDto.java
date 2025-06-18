package com.enaa.backend.Dto;

import com.enaa.backend.Model.Driver;
import jakarta.persistence.ManyToOne;

import java.util.Date;


public class TrajetDto {
    private Long id;

    private String lieuDepart;
    private String etapeIntermidiaire;
    private String destinationFinal;
    private Date dateDepart;
    private String dimensionMax;
    private String typeMarchandise;
    private Long capaciteDespo;

    public TrajetDto() {
    }

    public TrajetDto(Long id, String lieuDepart, String etapeIntermidiaire, String destinationFinal, Date dateDepart, String dimensionMax, String typeMarchandise, Long capaciteDespo, Driver driver) {
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

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
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
