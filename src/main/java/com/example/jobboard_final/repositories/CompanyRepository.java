package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("select c from Company c")
    List<Company> getCompanies(Pageable pageable);
    boolean existsById(Long id);
    @Query("select count(c) from Company c")
    int getTotalCompany();
}
