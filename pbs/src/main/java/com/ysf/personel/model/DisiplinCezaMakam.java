package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "disiplin_ceza_veren_makam")
@Data
public class DisiplinCezaMakam {
    @Id
    private String kodu;
    private String adi;
    private String aciklama;
    private String islem_sicilno;
    private Date Islem_tarihi;
}
