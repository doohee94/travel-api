package com.example.demo.company.entity;

import com.example.demo.user.entity.User;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_VISIT_COMPANY")
@SequenceGenerator(name = "USER_VISIT_COMPANY_SEQ_GEN",
        sequenceName = "USER_VISIT_COMPANY_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
public class UserVisitCompany {
    @Id
    @Column(name = "USER_VISIT_COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_VISIT_COMPANY_SEQ_GEN")
    private Long id;

    private LocalDateTime dataTime;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Company company;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

}
