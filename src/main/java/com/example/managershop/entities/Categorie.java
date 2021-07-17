package com.example.managershop.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
   // @NotBlank(message = "Name is mandatory")
    //@Column(length=50)
    //@Size(max = 30 , min = 8)
    private String nomCat;
    //@Column(columnDefinition = "boolean default false")
    private Boolean archived=false;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Produit> produits= new ArrayList<>();

    public Categorie(Long idCat, String nomCat) {
        this.idCat = idCat;
        this.nomCat = nomCat;
    }

    public Categorie(String nomCat) {
        this.nomCat = nomCat;
    }
}
