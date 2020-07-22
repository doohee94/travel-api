package com.example.demo.company.dto;

import com.example.demo.common.model.Address;
import com.example.demo.common.model.ListResult;
import com.example.demo.company.entity.Company;
import com.example.demo.company.entity.CompanyDeleted;
import com.example.demo.company.entity.Reason;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyDto {

    @Getter
    @NoArgsConstructor
    public static class CompanyCreate{
        private String name;
        private Address address;
        private long tourist;

        public CompanyCreate(String name, Address address, long tourist) {
            this.name = name;
            this.address = address;
            this.tourist = tourist;
        }

        public static Company toEntity(CompanyCreate companyCreate, User user, Tourist tourist){
            return new Company(companyCreate, user, tourist);
        }

    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CompanyListResponse{

        private String name;
        private Address address;
        private String userName;
        private String tourist;

        public CompanyListResponse(Company company) {
            this.name = company.getName();
            this.address = company.getAddress();
            this.userName = company.getUser().getName();
            this.tourist = company.getTourist().getName();
        }
    }

    public static class ListResponse extends ListResult<CompanyListResponse>{
        public ListResponse(List<CompanyListResponse> content) {
            super(content);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CompanyDeleteReq{

        private Long companyId;
        private Reason reason;
        private String reasonDetail;

        public static CompanyDeleted toEntity(CompanyDeleteReq req, Company company){

            return new CompanyDeleted(req, company);

        }

    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CompanyDeletedRes{

        private String companyName;
        private Reason reason;
        private String reasonDetail;
        private LocalDateTime deleteDate;

        public CompanyDeletedRes(CompanyDeleted companyDeleted) {
            this.companyName = companyDeleted.getCompany().getName();
            this.reason = companyDeleted.getReason();
            this.reasonDetail = companyDeleted.getReasonDetail();
            this.deleteDate = companyDeleted.getDeletedDate();
        }
    }

    public static class ListResponseDelete extends ListResult<CompanyDeletedRes>{
        public ListResponseDelete(List<CompanyDeletedRes> content) {
            super(content);
        }
    }

}
