package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_gecici_gorev")
@Data
public class PersonelGeciciGorev {
    @Id
    private String sicil;
    @Column(name = "owner_isyerikodu")
    private String owner_isyerikodu;
    private String sayi;
    private String konu;
    @Column(name = "isyerikodu")
    private String isyerikodu;
    @Column(name = "serviskodu")
    private String serviskodu;
    @Column(name = "unvankodu")
    private String unvankodu;
    private Date baslamatarihi;
    private Date bitistarihi;
    private String islem_sicilno;
    private String durum;
    private String harcirah;
    private Date islem_tarihi;
    private String gecici_gorev_isyerikodu;
    private String gecici_gorev_serviskodu;
    private String belgeno;
    private Date belge_tarihi;
    private String gecici_gorev_diger;
    private String gecici_gorev_turu;
    private String gec_gorev_kurum;
    private String gerekce;
    private String sekli;
    private String yur_gorev;
    private String kp_statu;
    private String kp_unvan;

}


