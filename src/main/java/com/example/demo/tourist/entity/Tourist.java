package com.example.demo.tourist.entity;

import com.example.demo.city.entity.City;
import com.example.demo.common.model.Address;
import com.example.demo.tourist.dto.TouristDto;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tourist")
@SequenceGenerator(name = "TOURIST_SEQ_GEN",
        sequenceName = "TOURIST_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@Where(clause = "deleted = false")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"city","touristReviews"})
public class Tourist {

    @Id
    @Column(name = "TOURIST_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOURIST_SEQ_GEN")
    private Long id;

    private String name;
    private boolean deleted;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "CITY_ID")
    private City city;


    @OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TouristReview> touristReviews;

    @Builder
    public Tourist(String name, String cityStr, String load, String zipcode, City cityObj) {
        this.name = name;
        this.address = Address.builder().city(cityStr).load(load).zipcode(zipcode).build();
        this.city = cityObj;
    }

    public void deleteTourist() {
        this.deleted = true;
    }
}
