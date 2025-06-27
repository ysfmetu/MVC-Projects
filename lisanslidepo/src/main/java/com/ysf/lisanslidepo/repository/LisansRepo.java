package com.ysf.lisanslidepo.repository;

import com.ysf.lisanslidepo.model.LisansliDepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface LisansRepo extends JpaRepository<LisansliDepo, Long> {

    @Query("select p from LisansliDepo p where  CONCAT (lower(p.lisdepoadi)) like %?1%")
    public Page<LisansliDepo> findAll(Pageable page, String keyword);

    @Query(value = "SELECT max(sira) FROM LisansliDepo ")
    public int maxSira();

    List<LisansliDepo> findByOrderBySiraAsc();

    LisansliDepo findBySira(Integer sira);

    //(lower( p.lisdepoadi),lower( p.adres)) like %:keyword%")


}
