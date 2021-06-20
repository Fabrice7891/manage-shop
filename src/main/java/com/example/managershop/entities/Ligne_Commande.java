package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Ligne_Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idLigneCde;
    private double qteCde;
    private double prixCde;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Produit produit;
}
