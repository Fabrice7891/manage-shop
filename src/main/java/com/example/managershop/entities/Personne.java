package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Builder
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSON")
public abstract class Personne implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String civilitePerson;
    private String namePerson;
    private String lastNamePerson;
    private String emailPerson;
    private String villePerson;
    private String numCniPerson;
    private String photo;

}
