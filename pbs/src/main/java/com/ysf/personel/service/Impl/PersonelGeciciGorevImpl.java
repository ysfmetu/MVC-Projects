package com.ysf.personel.service.Impl;

import com.ysf.personel.model.PersonelGeciciGorev;
import com.ysf.personel.repository.PersonelGeciciGorevRepository;
import com.ysf.personel.service.PersonelGeciciGorevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonelGeciciGorevImpl implements PersonelGeciciGorevService {
    @Autowired
    private PersonelGeciciGorevRepository pggRepo;

    public Long findAllGGP() {
        return pggRepo.findAllGGP();
    }


    public List<PersonelGeciciGorev> geciciAll2021() {
        return pggRepo.findAll2021();
    }
}
