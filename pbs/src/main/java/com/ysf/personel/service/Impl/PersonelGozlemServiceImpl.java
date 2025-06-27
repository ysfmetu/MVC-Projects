package com.ysf.personel.service.Impl;

import com.ysf.personel.model.PersonelGozlem;
import com.ysf.personel.repository.PersonelGozlemRepository;
import com.ysf.personel.service.PersonelGozlemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonelGozlemServiceImpl implements PersonelGozlemService {
    @Autowired
    private PersonelGozlemRepository personelGozlemRepository;

    @Override
    public Optional<PersonelGozlem> findById(long id) {
        return personelGozlemRepository.findById(id);
    }

    @Override
    public PersonelGozlem findBySicil(String sicil) {
        return personelGozlemRepository.findBySicil(sicil);
    }

    public boolean checkSicilExists(String sicil) {
        if (null != findBySicil(sicil)) {
            return true;
        }
        return false;
    }

    @Override
    public List<PersonelGozlem> findAll() {
        return personelGozlemRepository.findAll();
    }

    @Override
    public void savePersonel(PersonelGozlem personel) {
        personelGozlemRepository.save(personel);
    }
}
