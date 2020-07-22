package com.example.demo.user.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
@Getter
@SequenceGenerator(name = "ROLE_SEQ_GEN",
        sequenceName = "ROLE_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class Role {


    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "ROLE_SEQ_GEN")
    private Long id;

    private  String userRole;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

}
