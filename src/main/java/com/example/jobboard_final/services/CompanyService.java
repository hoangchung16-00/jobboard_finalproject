package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Company;
import com.example.jobboard_final.entities.MyUserDetails;
import com.example.jobboard_final.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Company getById(Long id){
        return companyRepository.getById(id);
    }

    @Transactional
    public boolean existsById(Long id){
        return companyRepository.existsById(id);
    }

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

    @Transactional
    public void editCompany(Company company){
        Company c = getById(company.getId());
        if(company.getImage()!= null){
            c.setImage(company.getImage());
        }
        c.setAddress(company.getAddress());
        c.setDescription(company.getDescription());
        c.setEmail(company.getEmail());
        c.setEmployee(company.getEmployee());
        c.setFoundationyear(company.getFoundationyear());
        c.setName(company.getName());
        c.setPhonenumber(company.getPhonenumber());
        c.setShortdescription(company.getShortdescription());
        c.setWebsite(company.getWebsite());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ((MyUserDetails) principal).getUser().setCompany(c);
        companyRepository.save(c);
    }

    @Transactional
    public void setImageForCompany(Company company,String image){
        company.setImage(image);
    }

    @Transactional
    public String getImage(Long id){
        return getById(id).getImage();
    }
}
