package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_nufuscuzdani")
@Data
public class PersonelNufusCuzdani {
    @Id
    private String sicil;
    private Date dogumasil;
    private Date dogumtashih;
    private int dogum_il;
    private String dogumilce;
    private int nufuskayitli_il;
    private String nufuskayitliilce;
    private String nufusmahalle;
    private String nufusciltno;
    private String nufussayfano;
    private String nufuskutukno;
    private String cuzdan_serino;
    private int cuzdan_no;
    private String verildigi_yer;
    private String verilis_nedeni;
    private String kayit_no;
    private Date verilis_tarihi;
    private String baba_adi;
    private String anne_adi;
    private String islem_sicilno;
    private Date islem_tarihi;
    private String tc_kimlik;
}
