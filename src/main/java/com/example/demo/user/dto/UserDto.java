package com.example.demo.user.dto;

import com.example.demo.common.model.Address;
import com.example.demo.common.model.ListResult;
import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.entity.Company;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.user.entity.Role;
import com.example.demo.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class UserDto {

    @Getter
    @NoArgsConstructor
    public static class CreateMemberUser{

        private String name;
        private String email;
        private String password;
        private Address address;
        List<String> userLikeCities;

        public CreateMemberUser(String name, String email, String password, Address address, List<String> userLikeCities) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.address = address;
            this.userLikeCities = userLikeCities;
        }

        public static User toEntity(CreateMemberUser userDto, Role role) {
            return new User(userDto, role);
        }
    }

    @Getter
    @NoArgsConstructor
    public static class CreateCompany {

        private String name;
        private String email;
        private String password;
        private Address address;
        private CompanyDto.CompanyCreate company;

        public static User toEntity(CreateCompany userDto, Role role) {
            return new User(userDto, role);
        }

        public static Company toEntity(CreateCompany userDto, User user, Tourist tourist){
            return  new Company(userDto, user, tourist);
        }

    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UserRes{

        private String name;
        private String email;
        private Address address;

        public UserRes(User user) {
            this.name = user.getName();
            this.email = user.getEmail();
            this.address = user.getAddress();
        }
    }
    public static class ListResponse extends ListResult<UserRes> {
        public ListResponse(List<UserRes> content) {
            super(content);
        }
    }

}
