package com.example.job.services;

import com.example.job.entities.Account;
import com.example.job.entities.Company;
import com.example.job.entities.MyUserDetails;
import com.example.job.forms.RegisterForm;
import com.example.job.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private EmailService emailService;

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

    @Transactional
    public boolean existsByEmail(String email){
        return companyRepository.existsByEmail(email);
    }

    @Transactional
    public void register(RegisterForm registerForm, Account account, String siteURL) throws UnsupportedEncodingException, MessagingException {
        Company company = new Company();
        company.setEmail(registerForm.getEmail());
        company.setAccount(account);
        company.setName(registerForm.getName());
        company.setShortdescription("");
        company.setAddress("");
        company.setPhonenumber("");
        company.setEmployee(1);
        company.setImage("company.png");
        companyRepository.save(company);
        emailService.sendCompanyVerificationEmail(company,siteURL);
    }
}
