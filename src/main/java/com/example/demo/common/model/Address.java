package com.example.demo.common.model;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

    String city;
    String load;
    String zipcode;

    @Builder
    public Address(String city, String load, String zipcode) {
        this.city = city;
        this.load = load;
        this.zipcode = zipcode;
    }
}
