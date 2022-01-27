package com.example.job.repositories;

import com.example.job.entities.Company;
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

    @Query("select c from Company c where c.id=?1")
    Company getById(Long id);

    boolean existsByEmail(String email);
}
