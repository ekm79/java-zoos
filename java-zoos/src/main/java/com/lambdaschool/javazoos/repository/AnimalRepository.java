package com.lambdaschool.javazoos.repository;

import com.lambdaschool.javazoos.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    Animal getAnimalByAnimaltype(String type);
}
