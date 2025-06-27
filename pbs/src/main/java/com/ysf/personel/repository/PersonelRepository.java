package com.ysf.personel.repository;


import com.ysf.personel.model.PersonelInfo;
import com.ysf.personel.model.PersonelSondurum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonelRepository extends JpaRepository<PersonelInfo, Long> {
    PersonelInfo findBySicil(String sicil);

    PersonelInfo findByTelefon(String telefon);

    void deleteBySicil(String sicil);

    @Query(value = "SELECT count(id) FROM PersonelInfo")
    public long findCountEntity();

    //merkez
    @Query(value = "select p from PersonelInfo p where p.isyerikodu  like '00%' and p.isyerikodu not like '0018%'")
    public List<PersonelInfo> findAllMerkez();

    //taşra
    @Query(value = "select p from PersonelInfo p where (substring(p.isyerikodu,1,2) not like'00%') " +
            " or(substring(p.isyerikodu,1,4)='0018') ")
    public List<PersonelInfo> findAllTasra();

    @Query(value = "select y.define from ysf_pgg_properties y where y.value=:value ")
    public String findKangrubuAdı(String value);


}
