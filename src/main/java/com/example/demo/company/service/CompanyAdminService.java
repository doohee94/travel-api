package com.example.demo.company.service;

import com.example.demo.company.dto.CompanyDto;
import com.example.demo.company.dto.CompanyReviewDto;
import com.example.demo.company.entity.Company;
import com.example.demo.company.entity.CompanyDeleted;
import com.example.demo.company.repository.CompanyDeletedRepository;
import com.example.demo.company.repository.CompanyRepository;
import com.example.demo.tourist.dto.TouristReviewDto;
import com.example.demo.tourist.entity.Tourist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyAdminService {

    private final CompanyRepository companyRepository;
    private final CompanyDeletedRepository companyDeletedRepository;

    public List<CompanyDto.CompanyListResponse> getCompanies() {

        List<Company> companies  = companyRepository.findAllCompanies();

        return  companies.stream()
                .map(CompanyDto.CompanyListResponse::new)
                .collect(Collectors.toList());
    }

    public List<CompanyDto.CompanyListResponse> getNewCompanies() {

        List<Company> companies  = companyRepository.findByCheckAuth(false);

        return  companies.stream()
                .map(CompanyDto.CompanyListResponse::new)
                .collect(Collectors.toList());
    }


    public void allowCompanyAuth(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(NullPointerException::new);
        company.allowAuth();
    }

    public List<CompanyDto.CompanyDeletedRes> getRequireDeleteCompanies() {

        List<CompanyDeleted> companyDeleteds = companyDeletedRepository.findAllByAllow(false);

        return companyDeleteds.stream().map(CompanyDto.CompanyDeletedRes::new).collect(Collectors.toList());
    }

    public void allowDeleteCompany(Long id) {

        CompanyDeleted companyDeleted = companyDeletedRepository.findByIdForDelete(id)
                .orElseThrow(NullPointerException::new);

        companyDeleted.allowDelete();
        companyDeleted.getCompany().delete();

    }

    public List<CompanyReviewDto.ReviewRes> getTouristReviews() {
        List<Company> tourists = companyRepository.findAllForTourist();

        List<CompanyReviewDto.ReviewRes> list = new ArrayList<>();
        for (Company company : tourists) {
            list.addAll(company.getCompanyReviewList().stream() .map(CompanyReviewDto.ReviewRes::new)
                    .collect(Collectors.toList()));
        }

        return list;
    }
}
