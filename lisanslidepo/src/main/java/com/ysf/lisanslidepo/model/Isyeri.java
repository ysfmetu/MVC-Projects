package com.ysf.lisanslidepo.model;

import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ysf_isyeri")
@Data
public class Isyeri {
    @Id
    private long id;
    private String isyerikodu;
    private String isyeriadi;
}
