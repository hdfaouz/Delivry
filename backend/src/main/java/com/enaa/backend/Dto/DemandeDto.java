package com.enaa.backend.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class DemandeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String dimensionsColis;
    private double poidsColis;
    private String typeColis;

    public DemandeDto() {
    }

    public DemandeDto(Long id, String dimensionsColis, double poidsColis, String typeColis) {
        this.id = id;
        this.dimensionsColis = dimensionsColis;
        this.poidsColis = poidsColis;
        this.typeColis = typeColis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDimensionsColis() {
        return dimensionsColis;
    }

    public void setDimensionsColis(String dimensionsColis) {
        this.dimensionsColis = dimensionsColis;
    }

    public double getPoidsColis() {
        return poidsColis;
    }

    public void setPoidsColis(double poidsColis) {
        this.poidsColis = poidsColis;
    }

    public String getTypeColis() {
        return typeColis;
    }

    public void setTypeColis(String typeColis) {
        this.typeColis = typeColis;
    }
}
