package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class ysf_pgg_properties {
    @Id
    private long id;
    private String value;
    private String define;

}
