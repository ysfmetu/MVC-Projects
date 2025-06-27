package com.ysf.personel.service;

import com.ysf.personel.model.PersonelGozlem;

import java.util.List;
import java.util.Optional;

public interface PersonelGozlemService {

    Optional<PersonelGozlem> findById(long id);

    PersonelGozlem findBySicil(String sicil);

    List<PersonelGozlem> findAll();

    void savePersonel(PersonelGozlem personel);

    boolean checkSicilExists(String sicil);


}
