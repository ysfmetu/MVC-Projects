package com.ysf.personel.service;

import com.ysf.personel.model.Disiplin;

import java.util.List;

public interface DisiplinService {

    boolean checkSicilExists(String sicil);

    List<Disiplin> findBySicil(String sicil);
}
