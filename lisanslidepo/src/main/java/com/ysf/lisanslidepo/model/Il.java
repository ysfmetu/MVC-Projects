package com.ysf.lisanslidepo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ysf_il")
@Data
public class Il {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "il_id")
    private long id;
    private String ilkodu;
    private String iladi;
}
