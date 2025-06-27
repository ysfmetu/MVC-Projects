package com.ysf.personel.repository;


import com.ysf.personel.model.PersonelHareket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelHareketRepository extends JpaRepository<PersonelHareket, String> {

    //personel hareket listesi
    @Query(value = "select new com.ysf.personel.model.PersonelHareket(p.islem_baslama_tarihi,p.islemturu,p.isyerikodu," +
            "p.unvankodu,p.eski_isyerikodu,p.eski_unvankodu,p.islemturu_detay)" +
            " from PersonelHareket p where p.sicil=:sicil and p.islemturu in(10,20) order by p.islem_baslama_tarihi")
    public List<PersonelHareket> findPersonelHareketInfo(String sicil);

    @Query(value = "select p.adi from PersonelIslemturuDetay p where p.detay_kodu=:detaykodu ")
    public String findIslemturuDetay(String detaykodu);
}
