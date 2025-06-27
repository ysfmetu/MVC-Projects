package com.ysf.lisanslidepo.service;

import com.ysf.lisanslidepo.model.LisansliDepo;
import com.ysf.lisanslidepo.repository.LisansRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LisansServiceImpl implements LisansService {
    @Autowired
    private LisansRepo lisansRepo;


    @Override
    public List<LisansliDepo> getAllLisans() {
        return lisansRepo.findAll();
    }

    @Override
    public LisansliDepo getLisansliDepoById(long id) {
        Optional<LisansliDepo> optional = lisansRepo.findById(id);
        LisansliDepo lisansliDepo = null;

        if (optional.isPresent()) {
            lisansliDepo = optional.get();
        } else {
            throw new RuntimeException(" Lisanslı depo bulunamadı :: " + id);
        }
        return lisansliDepo;

    }

    @Override
    public void saveEmployee(LisansliDepo lisansliDepo) {
        this.lisansRepo.save(lisansliDepo);
    }


    @Override
    public Page<LisansliDepo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);

        if (keyword != null) {
            return lisansRepo.findAll(pageable, keyword);
        }
        return lisansRepo.findAll(pageable);
    }

    @Override
    public int maxSira() {
        return lisansRepo.maxSira();
    }
}
