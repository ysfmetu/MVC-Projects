package com.ysf.personel.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class DisiplinOzet {
    @Id
    private String sicil;
    private String isyerikodu;
    private Date cezatarihi;
    private String cezamakamadi;
    private Integer onerilencezakodu;
    private String onerilencezaadi;
    private Integer sorusturmakonukodu;
    private String sorusturmakonuadi;
    private String aciklama;

    public DisiplinOzet(String sicil, String isyerikodu, Date cezatarihi, String cezamakamadi,
                        Integer onerilencezakodu, String onerilencezaadi, Integer sorusturmakonukodu, String sorusturmakonuadi, String aciklama) {
        this.sicil = sicil;
        this.isyerikodu = isyerikodu;
        this.cezatarihi = cezatarihi;
        this.cezamakamadi = cezamakamadi;
        this.onerilencezakodu = onerilencezakodu;
        this.onerilencezaadi = onerilencezaadi;
        this.sorusturmakonukodu = sorusturmakonukodu;
        this.sorusturmakonuadi = sorusturmakonuadi;
        this.aciklama = aciklama;
    }
}
