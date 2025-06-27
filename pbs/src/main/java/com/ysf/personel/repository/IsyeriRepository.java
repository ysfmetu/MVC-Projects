package com.ysf.personel.repository;

import com.ysf.personel.model.Isyeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IsyeriRepository extends JpaRepository<Isyeri, String> {
    //işyeri kodundan işyeri adı bulma
    @Query(value = "select i.isyeriadi from Isyeri i where i.isyerikodu=:isyeri")
    public String findByIsyeriAdi(String isyeri);

}
