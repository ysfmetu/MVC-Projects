package com.ysf.personel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "personel_hareket_turu_detay")
public class PersonelIslemturuDetay {
    @Id
    private Integer kodu;
    private String detay_kodu;
    private String adi;
    private String islem_sicilno;
    private Date islem_tarihi;
    private Integer dpb_kodu;
}
