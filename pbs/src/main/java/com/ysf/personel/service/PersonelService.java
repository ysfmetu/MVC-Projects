package com.ysf.personel.service;

import com.ysf.personel.model.PersonelInfo;

import java.util.List;
import java.util.Optional;

public interface PersonelService {
    List<PersonelInfo> personelAll();

    List<PersonelInfo> personelMerkez();

    List<PersonelInfo> personelTasra();


    PersonelInfo findBySicil(String sicil);

    PersonelInfo findById(Long id);

    Optional<PersonelInfo> getPersonelId(Long id);

    void savePersonel(PersonelInfo user);

    boolean checkPersonelExists(String sicil, String telefon);

    boolean checkSicilExists(String sicil);

    boolean checkTelefonExists(String telefon);

    void deletePersonelInfoBySicil(String sicil);

    public Long findCountEntity();
}
