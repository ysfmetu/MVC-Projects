package com.ysf.personel.model.security;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

/**
 * Created by ysf on 15/11/20.
 */
@Data
public class Authority implements GrantedAuthority {

    private final String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

}
