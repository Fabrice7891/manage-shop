package com.example.managershop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@DiscriminatorValue("USER")
public class User extends Personne {
    private String password;
    private String photo;
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Collection<Role> roles= new ArrayList<>();
}
