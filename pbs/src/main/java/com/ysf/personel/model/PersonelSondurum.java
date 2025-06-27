package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_sondurum")
@Data
public class PersonelSondurum {
    @Id
    private String sicil;
    @Column(name = "isyerikodu")
    private String isyerikodu;
    @Column(name = "serviskodu")
    private String serviskodu;
    @Column(name = "unvankodu")
    private String unvankodu;
    @Column(name = "sirano")
    private int sirano;
    private int ekgostergekodu;
    private String vergiindirimgrubu;
    @Column(name = "khaderece")
    private int khaderece;
    @Column(name = "khakademe")
    private int khakademe;
    private Date khaterfi;
    @Column(name = "ekeaderece")
    private int ekeaderece;
    @Column(name = "ekeakademe")
    private int ekeakademe;
    private Date ekeaterfi;
    private int ekgosterge;
    private Date kidemgecerliktarihi;
    @Column(name = "kidemkha")
    private int kidemkha;
    @Column(name = "kidemekea")
    private int kidemekea;
    @Column(name = "kidemsozlesmeli")
    private int kidemsozlesmeli;
    @Column(name = "kidemtoplam")
    private int kidemtoplam;
    private String sinif;
    private String statu;
    @Column(name = "tahsilkodu")
    private String tahsilkodu;
    private String unvan_detaykodu;
    private String tedvir_isyerikodu;
    private String tedvir_serviskodu;
    private String tedvir_unvankodu;
    private String islem_sicilno;
    private String aktif_pasif;
    private String tipno;
    private String okul;
    private String fakulte;
    private String bolum;
    private String asalet_durumu;
    @Column(name = "yevmiye")
    private int yevmiye;
    @Column(name = "kadroderece")
    private int kadroderece;
    private int ogrenim_tipi;
    private int ogrenim_suresi;
    @Column(name = "islem_tarihi")
    private Date islem_tarihi;
    private Date mezuniyet_tarihi;
    private int kha_ekgosterge;
    private int ekea_ekgosterge;
    private String arsivno;
    private int calismadigi_gun_sayisi;
    private String statu_detay;
    private Date mezuniyet_ibraz_tarihi;
    private int kidem_extra;


}

