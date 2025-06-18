package com.enaa.backend.Model;

import jakarta.persistence.*;

@Entity
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    private String dimensionsColis;
    private double poidsColis;
    private String typeColis;

    public Demande() {
    }

    public Demande(Long id, String dimensionsColis, double poidsColis, String typeColis, StatutDemand statut, Sender sender, Trajet trajet) {
        this.id = id;
        this.dimensionsColis = dimensionsColis;
        this.poidsColis = poidsColis;
        this.typeColis = typeColis;
        this.statut = statut;
        this.sender = sender;
        this.trajet = trajet;
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

    public StatutDemand getStatut() {
        return statut;
    }

    public void setStatut(StatutDemand statut) {
        this.statut = statut;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatutDemand statut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Sender sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trajet_id", nullable = false)
    private Trajet trajet;


}
