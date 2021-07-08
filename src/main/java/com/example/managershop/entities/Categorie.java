package com.example.managershop.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nomCat;
    private boolean archived=false;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Produit> produits= new ArrayList<>();

    public Categorie(Long idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }
}
