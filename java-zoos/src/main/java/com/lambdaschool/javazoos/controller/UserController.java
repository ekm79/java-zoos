package com.lambdaschool.javazoos.controller;

import com.lambdaschool.javazoos.model.User;
import com.lambdaschool.javazoos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User newUser) {
        return userRepo.save(newUser);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserById(@PathVariable long id) {
        var foundUser = userRepo.findById(id);
        if (foundUser.isPresent()) {
            userRepo.deleteById(id);
            return foundUser.get();
        } else {
            return null;
        }
    }
}
