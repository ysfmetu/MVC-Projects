package com.ysf.lisanslidepo.model;


import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lisansli_depo")
@Data
public class LisansliDepo {
    @Id
    private long lisdepono;
    @Size(min = 2, message = "Title must be at least 2 characters long")
    private String lisdepoadi;
    private int sira;
    private int subeno;
    private String adres;
    private int depo_min;
    private int depo_max;
    private String aktif;
    private String lisansli_depoculuk_no;
    private String yetkili_siniflandirici_no;
    private String yetkili_siniflandirici_adi;
    private int bagli_oldugu_il;
    @NotEmpty(message = "şube bos bırakılamaz.")
    @NotNull(message = "şube boş bırakılamaz")
    private String bagli_oldugu_sube;
    private String bagli_oldugu_alim_noktasi;






}
