package com.example.demo.company.service;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.entity.Company;
import com.example.demo.company.entity.CompanyDeleted;
import com.example.demo.company.repository.CompanyDeletedRepository;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.tourist.entity.Tourist;
import com.example.demo.tourist.repository.TouristRepository;
import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final UserRepository userRepository;
    private final TouristRepository touristRepository;
    private final CompanyRepository companyRepository;
    private final CompanyDeletedRepository companyDeletedRepository;

    public void createCompany(CompanyDto.CompanyCreate companyDto) {
        //TODO : user 로그인 시 가져오기 일단 3번으로
        User user = userRepository.findById(3L).orElseThrow(NullPointerException::new);

        Tourist tourist = touristRepository.findById(companyDto.getTourist()).orElseThrow(NullPointerException::new);
        Company company = CompanyDto.CompanyCreate.toEntity(companyDto, user, tourist);

        companyRepository.save(company);

    }

    public void requireDelete(CompanyDto.CompanyDeleteReq req) {
        Company company = companyRepository.findById(req.getCompanyId()).orElseThrow(NullPointerException::new);

        companyDeletedRepository.save(CompanyDto.CompanyDeleteReq.toEntity(req, company));

    }
}
