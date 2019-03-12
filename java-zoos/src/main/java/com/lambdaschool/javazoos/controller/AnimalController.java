package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.model.Animal;
import com.lambdaschool.javazoos.model.Zoo;
import com.lambdaschool.javazoos.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/animals", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController {

    @Autowired
    AnimalRepository animalRepo;


    @GetMapping("/animals")
    public List<Animal> getAllAnimals() {
        return animalRepo.findAll();
    }

    @GetMapping("/{name}")
    public Animal getSingleAnimal(@PathVariable String name) {
        return animalRepo.getAnimalByAnimaltype(name);
    }
}
