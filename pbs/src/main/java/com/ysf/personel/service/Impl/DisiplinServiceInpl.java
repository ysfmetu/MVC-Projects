package com.ysf.personel.service.Impl;

import com.ysf.personel.model.Disiplin;
import com.ysf.personel.repository.DisiplinRepository;
import com.ysf.personel.service.DisiplinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisiplinServiceInpl implements DisiplinService {
    @Autowired
    private DisiplinRepository disiplinRepo;

    public boolean checkSicilExists(String sicil) {
        if (!findBySicil(sicil).isEmpty()) {
            return true;
        }
        return false;
    }

    public List<Disiplin> findBySicil(String sicil) {
        return disiplinRepo.findBySicil(sicil);
    }
}
