package com.ysf.personel.repository;

import com.ysf.personel.model.PersonelOzet;
import com.ysf.personel.model.PersonelSondurum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonelSondurumRepository extends JpaRepository<PersonelSondurum, String> {

    //özet tablo çıkarma -birden fazla tablodan kolon alma
    @Query(value = "SELECT new com.ysf.personel.model.PersonelOzet(p.sicil,p.ad,p.soyad," +
            "ps.isyerikodu,ps.unvankodu,ps.tahsilkodu,ps.okul,ps.bolum,ps.fakulte," +
            "pn.dogumilce,pn.dogumasil,pn.verildigi_yer,pn.dogum_il,ps.kidemtoplam,ps.arsivno)" +
            "FROM PersonelInfo p,PersonelNufusCuzdani pn,PersonelSondurum ps " +
            "where (p.sicil=:sicil) and (pn.sicil=:sicil) and(ps.sicil=:sicil)")
    public PersonelOzet findPersonelOzet(String sicil);


    //okul  kodundan okul adı bulma
    @Query(value = "select o.okuladi from Okul o where o.okul=:okul")
    public String findByOkulAdi(String okul);

    //Fakulte  kodundan okul adı bulma
    @Query(value = "select f.fakulteadi from Fakulte f where f.fakulte=:fakulte")
    public String findByFakulteAdi(String fakulte);

    //Bölüm  kodundan okul adı bulma
    @Query(value = "select b.bolumadi from Bolum b where b.bolum=:bolum")
    public String findByBolumAdi(String bolum);

    @Query(value = "select i.iladi from Il i where i.ilkodu=:ilkodu")
    public String findByIladi(int ilkodu);

    //toplam personel sayısı
    @Query(value = "SELECT count(sicil) FROM PersonelSondurum where aktif_pasif='A' ")
    public long findCountEntity();

    //taşra personel sayısı
    @Query(value = "select count(p.sicil) from PersonelSondurum p where (p.aktif_pasif='A' and " +
            "substring(p.isyerikodu,1,2) not like'00%') " +
            " or(p.aktif_pasif='A' and substring(p.isyerikodu,1,4)='0018') ")
    public long findTasraPersonelSayi();

    //merkez personel sayısı
    @Query(value = "select count(sicil) from PersonelSondurum where aktif_pasif='A' and isyerikodu  like '00%' and isyerikodu not like '0018%'")
    public long findMerkezPersonelSayi();


}
