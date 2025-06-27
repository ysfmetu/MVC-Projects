package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teftis_sorusturma_konusu")
@Data
public class DisiplinSorusturma {
    @Id
    private Integer sorusturma_konu_kodu;
    private String sorusturma_konusu;
}
