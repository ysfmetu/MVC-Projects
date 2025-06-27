package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ysf_personel_gozlem1")
@Data
public class PersonelGozlem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    private String sicil;
    @Lob
    @Column(name = "fotograf", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;
}
