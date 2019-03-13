package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.model.Animal;
import com.lambdaschool.javazoos.model.Telephone;
import com.lambdaschool.javazoos.model.Zoo;
import com.lambdaschool.javazoos.repository.AnimalRepository;
import com.lambdaschool.javazoos.repository.TelephoneRepository;
import com.lambdaschool.javazoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    @Autowired
    AnimalRepository animalRepo;

    @Autowired
    ZooRepository zooRepo;

    @Autowired
    TelephoneRepository phoneRepo;

    @GetMapping("/phone")
    public List<Telephone> getAllPhone() {
        return phoneRepo.findAll();
    }

    @GetMapping("/zooanimals")
    public List<Optional<?>> getZooAnimals() {
        return zooRepo.findZooAnimals();
    }


    @PostMapping("/zoos")
    public Zoo addZoo(@RequestBody Zoo newZoo) {
        return zooRepo.save(newZoo);
    }

    @PostMapping("/phones")
    public Telephone addTelephone(@RequestBody Telephone newPhone) {
        return phoneRepo.save(newPhone);
    }

    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody Animal newAnimal) {
        return animalRepo.save(newAnimal);
    }

    @PostMapping("/zoos/animals")
    public Optional<?> addZooAnimal(@RequestBody Zoo zoo, @RequestBody Animal animal) {
        return zooRepo.addZooAnimal(zoo.getZooid(), animal.getAnimalid());
    }

    @PutMapping("/zoos/{id}")
    public Zoo updateZoo(@RequestBody Zoo newZoo, @PathVariable long id) {
        Zoo zoo = zooRepo.findById(id).orElseThrow();
        if (zoo != null) {
            newZoo.setZooid(id);
            zooRepo.save(newZoo);
            return newZoo;
        } else {
            return null;
        }
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@RequestBody Animal newAnimal, @PathVariable long id) {
        Animal animal = animalRepo.findById(id).orElseThrow();
        if (animal != null) {
            newAnimal.setAnimalid(id);
            animalRepo.save(newAnimal);
            return newAnimal;
        } else {
            return null;
        }
    }

    @PutMapping("/phones/{id}")
    public Telephone updatePhone(@RequestBody Telephone newPhone, @PathVariable long id) {
        Telephone phone = phoneRepo.findById(id).orElseThrow();
        if (phone != null) {
            newPhone.setPhoneid(id);
            phoneRepo.save(newPhone);
            return newPhone;
        } else {
            return null;
        }
    }

    @DeleteMapping("/zoos/{id}")
    public Zoo deleteZoo(@PathVariable long id) {
        Zoo zoo = zooRepo.findById(id).orElseThrow();
        if (zoo != null) {
            zooRepo.delete(zoo);
            return zoo;
        } else {
            return null;
        }
    }

    @DeleteMapping("/phones/{id}")
    public Telephone deletePhone(@PathVariable long id) {
        Telephone phone = phoneRepo.findById(id).orElseThrow();
        if (phone != null) {
            phoneRepo.delete(phone);
            return phone;
        } else {
            return null;
        }
    }

    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimal(@PathVariable long id) {
        Animal animal = animalRepo.findById(id).orElseThrow();
        if (animal != null) {
            animalRepo.delete(animal);
            return animal;
        } else {
            return null;
        }
    }

    @DeleteMapping("/admin/zoos/{zooid}/animals/{animalid}")
    public void deleteZooAnimal(@PathVariable long zooid, @PathVariable long animalid) {
//        Zoo zoo = zooRepo.findById(zooid).orElseThrow();
//        Animal animal = animalRepo.findById(animalid).orElseThrow();
        zooRepo.deleteZooAnimal(zooid, animalid);
    }

}

//
//        For the PUT and POST you can assume you are sent all the data with the appropriate ids included
//

//
//        POST /admin/zoos/animals - add the zooid, animalid combination to the zoo animals relations table


//        DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids.
//
//        Hint: @PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid