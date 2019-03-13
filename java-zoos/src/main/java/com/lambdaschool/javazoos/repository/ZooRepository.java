package com.lambdaschool.javazoos.repository;

import com.lambdaschool.javazoos.model.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ZooRepository extends JpaRepository<Zoo, Long> {

    Zoo findZooByZoonameEquals(String zooname);

    @Query (value = "DELETE Zoo.zooid, Animal.animalid FROM zooanimals", nativeQuery = true)
    void deleteZooAnimal(long zooid, long animalid);

    @Query(value = "INSERT Zoo.zooid, Animal.animalid INTO zooanimals", nativeQuery = true)
    Optional<?> addZooAnimal(long zooid, long animalid);

    @Query(value = "SELECT Zoo.zooname, Animal.animaltype FROM Zoo, Animal" +
            "JOIN zooanimals WHERE zooanimals.zooid == Zoo.zooid, zooanimals.animalid == Animal.animalid", nativeQuery = true)
    List<Optional<?>> findZooAnimals();
}
