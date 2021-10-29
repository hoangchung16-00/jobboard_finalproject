package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Company;
import com.example.jobboard_final.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public List<Company> getCompanies(Pageable pageable){
        List<Company> companies = companyRepository.getCompanies(pageable);
        for (Company c: companies) {
            c.getJobList().size();
        }
        return companyRepository.getCompanies(pageable);
    }
    @Transactional
    public int getTotalCompany(){
        return companyRepository.getTotalCompany();
    }
}
