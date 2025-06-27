package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fakulte")
@Data
public class Fakulte {
    @Id
    private String fakulte;
    private String fakulteadi;
}
