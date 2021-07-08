package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Remise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRemise;
    private String nameRemise;
    private float tauxRemise;
    @OneToMany(mappedBy = "remise") // ie dans la table produit la cle etrangere sera id de la Remise
    private Collection<Produit> produits;
}
