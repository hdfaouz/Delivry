package com.enaa.backend.Dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DemandeDto {


    private String dimensionsColis;
    private double poidsColis;
    private String typeColis;




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
