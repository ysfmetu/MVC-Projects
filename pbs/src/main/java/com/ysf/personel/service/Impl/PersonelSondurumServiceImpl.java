package com.ysf.personel.service.Impl;

import com.ysf.personel.model.PersonelOzet;
import com.ysf.personel.repository.PersonelSondurumRepository;
import com.ysf.personel.service.PersonelSondurumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonelSondurumServiceImpl implements PersonelSondurumService {

    @Autowired
    private PersonelSondurumRepository sondurumRepo;

    @Override
    public Long findCountEntity() {
        return sondurumRepo.findCountEntity();
    }

    @Override
    public long findTasraSayi() {

        return sondurumRepo.findTasraPersonelSayi();
    }

    @Override
    public long findMerkezSayi() {
        return sondurumRepo.findMerkezPersonelSayi();
    }

    @Override
    public PersonelOzet findPersonelOzet(String sicil) {
        return sondurumRepo.findPersonelOzet(sicil);
    }


}
