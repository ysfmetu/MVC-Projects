package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_ogrenim_diger")
@Data
public class PersonelDigerOgrenim {
    @Id
    private String sicil;
    private String tipno;
    private String fakulte;
    private String bolum;
    private Integer ogrenim_tipi;
    private Date mezuniyet_tarihi;
    private Integer ogrenim_suresi;
    private String tahsilkodu;
    private Integer kayitno;
    private String okul;
    private Date mezuniyet_ibraz_tarihi;
    private String tez_konusu;
    private String sondurum;
    private Date islem_tarihi;

    public PersonelDigerOgrenim(String fakulte, String bolum, Date mezuniyet_tarihi, Integer ogrenim_suresi, String okul, Date mezuniyet_ibraz_tarihi) {
        this.fakulte = fakulte;
        this.bolum = bolum;
        this.mezuniyet_tarihi = mezuniyet_tarihi;
        this.ogrenim_suresi = ogrenim_suresi;
        this.okul = okul;
        this.mezuniyet_ibraz_tarihi = mezuniyet_ibraz_tarihi;
    }


}

