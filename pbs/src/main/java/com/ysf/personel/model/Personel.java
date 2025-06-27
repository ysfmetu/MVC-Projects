package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel")
@Data
public class Personel {
    @Id
    private String sicil;
    private String sicilno;
    private String sicilharf;
    private String adi;
    private String soyadi;
    private String kizliksoyadi;
    private Integer askerlikdurumu;
    private Integer iskolu;
    private Integer sendika;
    private String evtelefonu;
    private String kangrubu;
    private String emeklisicilno;
    private String sskno;
    private String vakifuyeno;
    private Date ofisegiristarihi;
    private String vergiindirimgrubu;
    private Integer medenihali;
    private String bagkurno;
    private String eskihukumlu;
    private String cinsiyet;
    private String islem_sicilno;
    private Date islem_tarihi;
    private String ozurlu;
    private Integer ozur_orani;
    private String ozur_tipi;
    private String maluliyet;
    private Date gorevTarihi6495;
    private String emekliSicil6495;
    private Date memuriyete_giris_tarihi;
    private Date sendika_uyelik_tarihi;

}