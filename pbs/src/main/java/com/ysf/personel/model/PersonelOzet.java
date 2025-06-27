package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class PersonelOzet {
    @Id
    private String sicil;
    private String ad;
    private String soyad;
    private String isyeriadi;
    private String unvanadi;
    private String tahsilkodu;
    private String okul;
    private String bolum;
    private String fakulte;
    private String dogumYeri;
    private Date dogumTarihi;
    private String dogumIl;
    private int dogumIll;
    private int kidemtoplam;
    private String disiplin;


    public PersonelOzet(String sicil, String ad, String soyad, String isyeriadi, String unvanadi,
                        String tahsilkodu, String okul, String bolum, String fakulte, String dogumYeri,
                        Date dogumTarihi, String dogumIl, int dogumIll, int kidemtoplam, String disiplin) {
        this.sicil = sicil;
        this.ad = ad;
        this.soyad = soyad;
        this.isyeriadi = isyeriadi;
        this.unvanadi = unvanadi;
        this.tahsilkodu = tahsilkodu;
        this.okul = okul;
        this.bolum = bolum;
        this.fakulte = fakulte;
        this.dogumYeri = dogumYeri;
        this.dogumTarihi = dogumTarihi;
        this.dogumIl = dogumIl;
        this.dogumIll = dogumIll;
        this.kidemtoplam = kidemtoplam;
        this.disiplin = disiplin;

    }
}
