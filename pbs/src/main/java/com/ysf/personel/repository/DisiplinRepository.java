package com.ysf.personel.repository;

import com.ysf.personel.model.Disiplin;
import com.ysf.personel.model.DisiplinOzet;
import com.ysf.personel.model.GeciciOzet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisiplinRepository extends JpaRepository<Disiplin, String> {
    /* @Query(value="select d from Disiplin d where d.sicil=:sicil ")*/
    List<Disiplin> findBySicil(String sicil);

    //özet tablo çıkarma -birden fazla tablodan kolon alma
    @Query(value = "SELECT new com.ysf.personel.model.DisiplinOzet(d.sicil,d.isyerikodu,d.ceza_tarihi," +
            "d.ceza_veren_makam,d.onerilen_ceza,d.aciklama,d.sorusturmano,d.ceza_veren_kisi,d.aciklama)" +
            "FROM Disiplin d  where d.sicil=:sicil")
    public List<DisiplinOzet> findDisiplinOzet(String sicil);

    //CEZA KODUNDAN CEZA ADI BULMA
    @Query(value = "select d.onerilen_ceza from DisiplinVerilenCeza d where d.onerilen_ceza_kodu=:cezakodu")
    public String findByVerilen_cezaAdi(Integer cezakodu);

    //MAKAM KODUNDAN MAKAM ADI BULMA
    @Query(value = "select d.adi from DisiplinCezaMakam d where d.kodu=:cezakodu")
    public String findByCezaMakamAdi(String cezakodu);

    //SORUŞTURMA KODUNDAN SORUŞTURMA ADI BULMA
    @Query(value = "select d.sorusturma_konusu from DisiplinSorusturma d where d.sorusturma_konu_kodu=:cezakodu")
    public String findBySorusturmaAdi(Integer cezakodu);

}
