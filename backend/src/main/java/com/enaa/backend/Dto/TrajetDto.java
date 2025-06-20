package com.enaa.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class TrajetDto {
    private String lieuDepart;
    private String etapeIntermidiaire;
    private String destinationFinal;
    private Date dateDepart;
    private String dimensionMax;
    private String typeMarchandise;
    private Long capaciteDespo;

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

}
