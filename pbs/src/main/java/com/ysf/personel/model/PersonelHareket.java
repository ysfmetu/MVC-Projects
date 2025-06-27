package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_hareket")
@Data
public class PersonelHareket {
    @Id
    private String sicil;
    private String belgeno;
    private Date belge_tarihi;
    private Date tarih;
    private Integer islemturu;
    private Date islem_baslama_tarihi;
    private Date islem_bitis_tarihi;
    private Integer tahsilkodu;
    private String isyerikodu;
    private String serviskodu;
    private String unvankodu;
    private Integer sirano;
    private String unvan_detaykodu;
    private String sinif;
    private String statu;
    private String aciklama;
    private Integer khaderece;
    private Date khaterfi;
    private Integer kha_ekgosterge;
    private Integer ekeaderece;
    private Date ekeaterfi;
    private Integer ekeakademe;
    private Integer ekea_ekgosterge;
    private Date islem_tarihi;
    private Integer ekgosterge;
    private Integer ekgostergekodu;
    private Integer kadroderece;
    private Integer kidem_toplam;
    private String islem_sicilno;
    private String nedeni;
    private String eski_isyerikodu;
    private String eski_serviskodu;
    private String eski_unvankodu;
    private Integer eski_sirano;
    private String eski_unvan_detaykodu;
    private String eski_sinif;
    private String eski_statu;
    private String teklif_sicil;
    private Integer eski_khaderece;
    private Integer eski_khakademe;
    private Date eski_khaterfi;
    private Integer eski_kha_ekgosterge;
    private Integer eski_ekeaderece;
    private Integer eski_ekeakademe;
    private Integer eski_ekea_ekgosterge;
    private Integer eski_ekgosterge;
    private Integer eski_ekgostergekodu;
    private Integer eski_kadroderece;
    private Date eski_ekeaterfi;
    private Integer eski_kidem_toplam;
    private Integer adayliksuresi;
    private String onay_sicil;
    private Date aslimemurluktarihi;
    private String dagitim1;
    private String dagitim2;
    private String dagitim3;
    private String durum;
    private String dayanak;
    private Integer yevmiye;
    private Integer eski_yevmiye;
    private String tipno;
    private String okul;
    private String fakulte;
    private String bolum;
    private Integer ogrenim_tipi;
    private Integer ogrenim_suresi;
    private Date mezuniyet_tarihi;
    private Integer arsivno;
    private Date teklif_tarihi;
    private Date onay_tarihi;
    private String islemturu_detay;
    private String hareket_yeri;
    private String gorevi;
    private String asalet_durumu;
    private Integer basari_ucreti;
    private Integer kidem_ucreti;
    private Integer yabanci_dil_ucreti;
    private Integer eski_basari_ucreti;
    private Integer eski_kidem_ucreti;
    private Integer eski_yabanci_dil_ucreti;
    private Integer eski_temel_ucret;
    private Integer calismadigi_gun_sayisi;
    private Integer sira_no;
    private String aciklama_genis;
    private String statu_detay;
    private String ilk_islem_sicilno;
    private Date ilk_islem_tarihi;


    public PersonelHareket(Date islem_baslama_tarihi, Integer islemturu, String isyerikodu, String unvankodu,
                           String eski_isyerikodu, String eski_unvankodu, String islemturu_detay) {
        this.islem_baslama_tarihi = islem_baslama_tarihi;
        this.islemturu = islemturu;
        this.isyerikodu = isyerikodu;
        this.unvankodu = unvankodu;
        this.eski_isyerikodu = eski_isyerikodu;
        this.eski_unvankodu = eski_unvankodu;
        this.islemturu_detay = islemturu_detay;
    }
}