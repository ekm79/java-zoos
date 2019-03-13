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

    @Query(value = "INSERT z.zooid, z.animalid INTO zooanimals z", nativeQuery = true)
    Optional<?> addZooAnimal(long zooid, long animalid);

    @Query(value = "SELECT z.zooname, a.animaltype FROM Zoo z, Animal a, zooanimals WHERE zooanimals.zooid == a.zooid and zooanimals.animalid == a.animalid", nativeQuery = true)
    List<Optional<?>> findZooAnimals();
}
