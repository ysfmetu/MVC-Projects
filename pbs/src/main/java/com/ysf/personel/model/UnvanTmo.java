package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "unvan")
@Data
public class UnvanTmo {
    @Id
    private String unvankodu;
    private String unvanadi;
    private int unvanucret;
    private int m0cetvel1;
    private int m0cetvel3;
    private int m0cetvel2;
    private int m0daimi;
    private int m0gecici;
    private int m1cetvel1;
    private int m1cetvel2;
    private int m1cetvel3;
    private int m1daimi;
    private int m1gecici;
    private int t0cetvel1;
    private int t0cetvel2;
    private int t0cetvel3;
    private int t0daimi;
    private int t0gecici;
    private int t1cetvel1;
    private int t1cetvel2;
    private int t1cetvel3;
    private int t1daimi;
    private int t1gecici;
    private int ucret_gostergesi;
    private Date islem_tarihi;
    private int tazminat_gostergesi;
    private String islem_sicilno;
    private String gosterge_alma_yeri;
    private String dpb_unvankodu;
}
