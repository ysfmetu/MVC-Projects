package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class GeciciOzet {
    @Id
    private String sicil;
    private String ad;
    private String soyad;
    private String unvan;
    private String owner_isyeri;
    private String other_isyeri;
    private Date baslamatarih;
    private Date bitistarih;
    private String aciklama;
    private String gorev_turu;
    private String isyeriadi2;
    private String isyeriadi1;
    private String durum;
    private String harcirah;


    public GeciciOzet(String sicil, String ad, String soyad, String owner_isyeri, String other_isyeri,
                      Date baslamatarih, Date bitistarih, String unvan, String gorev_turu, String durum, String harcirah, String aciklama) {
        this.sicil = sicil;
        this.ad = ad;
        this.soyad = soyad;
        this.owner_isyeri = owner_isyeri;
        this.other_isyeri = other_isyeri;
        this.baslamatarih = baslamatarih;
        this.bitistarih = bitistarih;
        this.aciklama = aciklama;
        this.unvan = unvan;
        this.durum = durum;
        this.gorev_turu = gorev_turu;
        this.harcirah = harcirah;

    }
}
