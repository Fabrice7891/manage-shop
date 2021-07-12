package com.example.managershop.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Builder
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    @NotNull
    private String nameRole;
    private int levelPriorite;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<User> users= new ArrayList<>();

    public Role(String nameRole, int levelPriorite) {
        this.nameRole = nameRole;
        this.levelPriorite = levelPriorite;
    }
}
