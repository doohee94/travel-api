package com.example.demo.company.entity;

import com.example.demo.company.dto.CompanyDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMPANY_DELETED")
@SequenceGenerator(name = "COMPANY_DELETED_SEQ_GEN",
        sequenceName = "COMPANY_DELETED_SEQ",
        initialValue = 1,
        allocationSize = 1)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyDeleted {

    @Id
    @Column(name = "COMPANY_DELETED_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANY_DELETED_SEQ_GEN")
    private Long id;

    @Enumerated(EnumType.STRING)
    private  Reason reason;
    private  String reasonDetail;
    private  LocalDateTime deletedDate;

    private Boolean allow;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private  Company company;

    public CompanyDeleted(CompanyDto.CompanyDeleteReq req, Company company) {
        this.reason = req.getReason();
        this.reasonDetail = req.getReasonDetail();
        this.deletedDate = LocalDateTime.now();
        this.company = company;
        this.allow = false;
    }

    public void allowDelete() {
        this.allow = true;
    }
}
