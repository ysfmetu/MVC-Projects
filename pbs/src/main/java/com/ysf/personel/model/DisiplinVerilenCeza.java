package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teftis_onerilen_ceza")
@Data
public class DisiplinVerilenCeza {
    @Id
    private Integer onerilen_ceza_kodu;
    private String onerilen_ceza;

}
