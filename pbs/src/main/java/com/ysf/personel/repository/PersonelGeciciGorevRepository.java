package com.ysf.personel.repository;

import com.ysf.personel.model.GeciciOzet;
import com.ysf.personel.model.PersonelGeciciGorev;
import com.ysf.personel.model.PersonelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelGeciciGorevRepository extends JpaRepository<PersonelGeciciGorev, String> {

    //tüm geçici görevlilerin sayısı
    @Query(value = "select count(pgg.sicil) from PersonelGeciciGorev pgg where year(pgg.baslamatarihi)=2021")
    public long findAllGGP();

    //tüm geçici görevlilerin listesi
    @Query(value = "SELECT pgg FROM PersonelGeciciGorev pgg where year(pgg.baslamatarihi)=2021")
    public List<PersonelGeciciGorev> findAll2021();

    //özet tablo çıkarma -birden fazla tablodan kolon alma
    @Query(value = "SELECT new com.ysf.personel.model.GeciciOzet(pg.sicil,p.ad,p.soyad," +
            "pg.owner_isyerikodu,pg.gecici_gorev_isyerikodu,pg.baslamatarihi,pg.bitistarihi," +
            "pg.unvankodu,pg.gecici_gorev_turu,pg.durum,pg.harcirah,pg.gecici_gorev_diger)" +
            "FROM PersonelGeciciGorev pg,PersonelInfo p" +
            "  where p.sicil=pg.sicil and year(pg.baslamatarihi)=2022")
    public List<GeciciOzet> findGeciciOzet();

    //işyeri kodundan işyeri adı bulma
    @Query(value = "select i.isyeriadi from Isyeri i where i.isyerikodu=:isyeri")
    public String findByIsyeriAdi(String isyeri);

    //unvan  kodundan unvan adı bulma
    @Query(value = "select u.unvanadi from UnvanTmo u where u.unvankodu=:unvankodu")
    public String findByUnvanAdi(String unvankodu);

    //GÖREV TÜRÜ BULMA
    @Query(value = "select y.define from ysf_pgg_properties  y where y.value=:value ")
    public String findByDurumAdi(String value);


}
