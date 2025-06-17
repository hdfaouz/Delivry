package com.enaa.backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String lieuDepart;
    private String etapeIntermidiaire;
    private String destinationFinal;
    private Date dateDepart;
    private String DimensionMax;
    private String typeMarchandise;
    private Long capaciteDespo;

    @ManyToOne
    private Driver driver;

}
