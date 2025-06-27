package com.ysf.personel.repository;

import com.ysf.personel.model.PersonelGozlem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonelGozlemRepository extends JpaRepository<PersonelGozlem, Long> {

    PersonelGozlem findBySicil(String sicil);
}
