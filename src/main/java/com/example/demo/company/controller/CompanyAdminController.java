package com.example.demo.company.controller;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.dto.CompanyReviewDto;
import com.example.demo.company.service.CompanyAdminService;
import com.example.demo.tourist.dto.TouristReviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/travel/admin")
@RequiredArgsConstructor
public class CompanyAdminController {

    private final CompanyAdminService companyAdminService;

    @GetMapping(value = "/companies")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto.ListResponse getCompanies(){
        return new CompanyDto.ListResponse(companyAdminService.getCompanies());
    }

    @GetMapping(value = "/new-companies")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto.ListResponse getNewCompanies(){
        return new CompanyDto.ListResponse(companyAdminService.getNewCompanies());
    }

    @PutMapping(value = "/companies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void  allowCompanyAuth(@PathVariable Long id){
        companyAdminService.allowCompanyAuth(id);
    }

    @GetMapping(value = "/require/companies")
    @ResponseStatus(HttpStatus.OK)
    public CompanyDto.ListResponseDelete getRequireDeleteCompanies(){
        return new CompanyDto.ListResponseDelete(companyAdminService.getRequireDeleteCompanies());
    }

    @PutMapping(value ="/require/companies/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void allowDeleteCompany(@PathVariable Long id){
        companyAdminService.allowDeleteCompany(id);
    }

    @GetMapping(value = "/company/review")
    @ResponseStatus(HttpStatus.OK)
    public CompanyReviewDto.ListResponse getReviews(){
        return new CompanyReviewDto.ListResponse(companyAdminService.getTouristReviews());
    }


}
