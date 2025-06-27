package com.ysf.personel.repository;

import com.ysf.personel.model.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface PersonelTmoRepository extends JpaRepository<Personel, String> {

    public Date findByOfisegiristarihi(String sicil);
}
