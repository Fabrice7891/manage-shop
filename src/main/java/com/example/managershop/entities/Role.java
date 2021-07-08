package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String nameRole;
    private int levelPriorite;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> users= new ArrayList<>();
}
