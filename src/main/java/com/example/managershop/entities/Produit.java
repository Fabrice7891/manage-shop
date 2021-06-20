package com.example.managershop.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPdt;
    private String nomPdt;
    private float prixAchatPdt;
    private float prixVentePdt;
    private double quantePdt;
    private LocalDate dateLivrasonPdt;
    private LocalDate datePremptonPdt;
    @ManyToOne
    @JoinColumn(name = "CODE_CAT")
    private Categorie categorie;
    @OneToMany(mappedBy = "produit")
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Ligne_Commande> ligne_commandes;
    @ManyToMany(mappedBy = "produits", fetch = FetchType.EAGER)
    private Collection<Fournisseur> fournisseurs= new ArrayList<>();
    @ManyToOne
    private Remise remise;
    @OneToOne(mappedBy = "produit")
    private ProduitPromo produitPromo;
}
