package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor @ToString
public class ProduitPromo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPdtpromo;
    private double soldeprome;
    private LocalDate dateDebutpromo;
    private LocalDate dateFinpromo;
    @OneToOne
    private Produit produit;
}
