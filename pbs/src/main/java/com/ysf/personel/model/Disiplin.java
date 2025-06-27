package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "disiplin_kisi")
@Data
public class Disiplin {
    @Id
    private String sicil;
    private int yil;
    private int sorusturmano;
    private String adsoyad;
    private Integer onerilen_ceza;
    private Integer verilen_ceza;
    private String unvankodu;
    private String isyerikodu;
    private Integer cezano;
    private Date ceza_tarihi;
    private String ceza_veren_makam;
    private String ceza_veren_kisi;
    private String karar_turu;
    private String ceza_iptal;
    private String verilen_ceza_orani;
    private String islem_sicilno;
    private Date islem_tarihi;
    private String aciklama;
    private String ceza_kodu_detay;

}