package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ysf_personel_info")
@Data
public class PersonelInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    private String sicil;
    private String telefon;
    private String kanGrubu;
    private String isyeri;
    private String isyerikodu;

}
