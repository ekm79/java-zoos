package com.lambdaschool.javazoos.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long zooid;

    private String zooname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "zooanimals",
            joinColumns = {@JoinColumn(name = "zooid")},
            inverseJoinColumns = {@JoinColumn(name = "animalid")})
    private Set<Animal> animals;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zooid")
    private Set<Telephone> telephones;

    public Zoo() {
    }
}
