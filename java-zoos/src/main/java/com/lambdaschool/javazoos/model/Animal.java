package com.lambdaschool.javazoos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long animalid;

    private String animaltype;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "animals")
    private Set<Zoo> zoos;

    public Animal() {
    }
}
