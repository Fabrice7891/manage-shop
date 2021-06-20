package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@DiscriminatorValue("CLT")
public class Client extends Personne{

    private double soldeDebit;
    private double soldeCredit;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    //@JoinColumn(name = "id_client1")
    private Collection<Commande> commandes = new ArrayList<>();

}
