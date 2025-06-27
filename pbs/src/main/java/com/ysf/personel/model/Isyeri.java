package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "isyeri")
@Data
public class Isyeri {
    @Id
    @Column(name = "isyerikodu")
    private String isyerikodu;
    private String bolge;
    private String sube;
    private String ajans;
    private String ekip;
    private Integer ilkodu;
    private String ilceadi;
    @Column(name = "sifre")
    private String durum;
    private String isyeriadi;

}
