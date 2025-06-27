package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "okul")
@Data
public class Okul {
    @Id
    private String tipno;
    private String okul;
    private String okulno;
    private String okuladi;
}

