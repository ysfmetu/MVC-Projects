package com.ysf.personel.model;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bolum")
@Data
public class Bolum {
    @Id
    private String bolum;
    private String bolumadi;
}
