package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFsseur;
    private String nameFsseur;
    private String phoneFsseur;
    private String addresseFsseur;
    private String emailFsseur;
    private String villeFsseur;
    private String paysFsseur;
    @ManyToMany(fetch = FetchType.EAGER)
    //@Fetch(value = FetchMode.SUBSELECT)
    private Collection<Produit> produits= new ArrayList<>();
}
