package com.ysf.personel.model.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "ysf_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
    @Id
//   @GeneratedValue(strategy = GenerationType.AUTO)
    private int roleId;

    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<UserRole> userRoles = new HashSet<>();


}
