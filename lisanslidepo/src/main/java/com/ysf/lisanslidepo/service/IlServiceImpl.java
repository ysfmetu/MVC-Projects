package com.ysf.lisanslidepo.service;

import com.ysf.lisanslidepo.model.Il;
import com.ysf.lisanslidepo.model.Isyeri;
import com.ysf.lisanslidepo.repository.IlRepo;
import com.ysf.lisanslidepo.repository.IsyeriRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IlServiceImpl implements IlService {
    @Autowired
    private IlRepo ilRepo;

    @Override
    public List<Il> getAllIl() {

        return ilRepo.findAll();
    }
}
