package com.ysf.lisanslidepo.repository;

import com.ysf.lisanslidepo.model.Il;
import com.ysf.lisanslidepo.model.Isyeri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IlRepo extends JpaRepository<Il, Long> {
}
