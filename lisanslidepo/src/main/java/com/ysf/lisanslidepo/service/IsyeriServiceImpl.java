package com.ysf.lisanslidepo.service;

import com.ysf.lisanslidepo.model.Isyeri;
import com.ysf.lisanslidepo.repository.IsyeriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsyeriServiceImpl implements IsyeriService {
    @Autowired
    private IsyeriRepo isyeriRepo;

    @Override
    public List<Isyeri> getAllIsyeri() {
        return isyeriRepo.findAll();
    }
}
