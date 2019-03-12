package com.lambdaschool.javazoos.repository;

import com.lambdaschool.javazoos.model.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
