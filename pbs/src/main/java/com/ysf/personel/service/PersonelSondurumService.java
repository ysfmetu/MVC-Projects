package com.ysf.personel.service;

import com.ysf.personel.model.PersonelOzet;

public interface PersonelSondurumService {

    public Long findCountEntity();

    public long findTasraSayi();

    public long findMerkezSayi();

    public PersonelOzet findPersonelOzet(String sicil);
}
