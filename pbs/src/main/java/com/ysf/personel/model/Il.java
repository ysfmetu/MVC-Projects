package com.ysf.personel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Il")
public class Il {
    @Id
    private int ilkodu;
    private String iladi;
    private int ilnufusu;
    private String cografibolgeadi;
}
