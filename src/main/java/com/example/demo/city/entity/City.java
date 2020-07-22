package com.example.demo.city.entity;

import com.example.demo.common.model.Address;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
@SequenceGenerator(name = "CITY_SEQ_GEN",
        sequenceName = "CITY_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
public class City {

    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITY_SEQ_GEN")
    private Long id;

    @Embedded
    private  Address address;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private   List<UserLikeCity> userLikeCities;


}
