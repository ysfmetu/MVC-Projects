package com.ysf.personel.repository;


import com.ysf.personel.model.PersonelDigerOgrenim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelDigerOgrenimRepository extends JpaRepository<PersonelDigerOgrenim, String> {
    //personel öğrenim listesi
    @Query(value = "select new com.ysf.personel.model.PersonelDigerOgrenim(p.fakulte,p.bolum,p.mezuniyet_tarihi,p.ogrenim_suresi," +
            "p.okul,p.mezuniyet_ibraz_tarihi)" +
            " from PersonelDigerOgrenim p where p.sicil=:sicil")
    public List<PersonelDigerOgrenim> findPersonelOgrenim(String sicil);
}
