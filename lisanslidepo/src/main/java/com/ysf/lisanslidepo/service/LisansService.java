package com.ysf.lisanslidepo.service;

import com.ysf.lisanslidepo.model.LisansliDepo;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LisansService {

    List<LisansliDepo> getAllLisans();

    LisansliDepo getLisansliDepoById(long id);

    void saveEmployee(LisansliDepo lisansliDepo);

    Page<LisansliDepo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword);

    public int maxSira();

}
