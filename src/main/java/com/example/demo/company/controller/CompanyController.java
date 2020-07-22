package com.example.demo.company.controller;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCompany(@RequestBody CompanyDto.CompanyCreate companyDto){
        companyService.createCompany(companyDto);
    }

    @PostMapping(value = "/require")
    @ResponseStatus(HttpStatus.CREATED)
    public void requireDelete(@RequestBody CompanyDto.CompanyDeleteReq req){
        companyService.requireDelete(req);
    }

}
