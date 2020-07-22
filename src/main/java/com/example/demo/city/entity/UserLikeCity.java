package com.example.demo.city.entity;

import com.example.demo.user.entity.User;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "USER_LIKE_CITY")
@SequenceGenerator(name = "USER_LIKE_CITY_SEQ_GEN",
        sequenceName = "USER_LIKE_CITY_SEQ",
        initialValue = 1,
        allocationSize = 1)
public class UserLikeCity {

    @Id
    @Column(name = "USER_LIKE_CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_LIKE_CITY_SEQ_GEN")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private  User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private  City city;

    @Builder
    public UserLikeCity(User user, City city) {
        this.user = user;
        this.city = city;
    }
}
