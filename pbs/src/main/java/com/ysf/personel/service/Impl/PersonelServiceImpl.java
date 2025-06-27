package com.ysf.personel.service.Impl;

import com.ysf.personel.model.PersonelInfo;
import com.ysf.personel.repository.PersonelRepository;
import com.ysf.personel.service.PersonelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonelServiceImpl implements PersonelService {
    @Autowired
    private PersonelRepository personelRepo;

    public void savePersonel(PersonelInfo personel) {
        personelRepo.save(personel);
    }

    public boolean checkPersonelExists(String sicil, String telefon) {
        if (checkSicilExists(sicil) || checkTelefonExists(telefon)) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkSicilExists(String sicil) {
        if (null != findBySicil(sicil)) {
            return true;
        }

        return false;
    }

    public boolean checkTelefonExists(String telefon) {
        if (null != findByTelefon(telefon)) {
            return true;
        }

        return false;
    }

    public PersonelInfo findBySicil(String sicil) {
        return personelRepo.findBySicil(sicil);
    }

    @Override
    public Optional<PersonelInfo> getPersonelId(Long id) {
        return personelRepo.findById(id);
    }

    @Override
    public PersonelInfo findById(Long id) {
        return personelRepo.getOne(id);
    }


    public PersonelInfo findByTelefon(String telefon) {
        return personelRepo.findByTelefon(telefon);
    }


    public List<PersonelInfo> personelAll() {
        // TODO Auto-generated method stub
        return personelRepo.findAll();
    }

    public List<PersonelInfo> personelMerkez() {
        return personelRepo.findAllMerkez();
    }

    public List<PersonelInfo> personelTasra() {
        return personelRepo.findAllTasra();
    }


    public void deletePersonelInfoBySicil(String sicil) {
        personelRepo.deleteBySicil(sicil);
    }

    public Long findCountEntity() {
        return personelRepo.findCountEntity();
    }
}
