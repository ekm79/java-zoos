package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.model.Zoo;
import com.lambdaschool.javazoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/zoos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController {

    @Autowired
    ZooRepository zooRepo;


    @GetMapping("/zoos")
    public List<Zoo> getAllZoos() {
        return zooRepo.findAll();
    }

    @GetMapping("/{name}")
    public Zoo getSingleZoo(@PathVariable String name) {
        Zoo zoo = null;
        for (Zoo z: zooRepo.findAll()){
            if (z.getZooname().toLowerCase().replaceAll(" ", "").equals(name)){
                zoo = z;
            }
        }
        return zoo;
    }
}
