package com.example.job.repositories;

import com.example.job.entities.Company;
import com.example.job.entities.RequestRecruit;
import com.example.job.entities.Status;
import com.example.job.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestRecruitRepository extends JpaRepository<RequestRecruit,Long> {
    @Query("select (count(rp) > 0) from RequestRecruit rp where rp.user.id=?1 and rp.job.id=?2")
    boolean existsByUserAndJob(Long userId,Long jobId);

    @Query("select (count(rp) > 0) from RequestRecruit rp where rp.user.idsocial=?1 and rp.job.id=?2")
    boolean existsByUserAndJob(String userId,Long jobId);

    @Query("select rp from RequestRecruit rp where rp.job.company=?1 and rp.status=?2")
    List<RequestRecruit> findByCompanyAndStatus(Company company, Status status, Pageable pageable);

    @Query("select rp from RequestRecruit rp where rp.job.company=?1")
    List<RequestRecruit> findByCompany(Company company, Pageable pageable);

    @Query("select count(rp) from RequestRecruit rp where rp.job.company=?1")
    int getTotalRequestByCompany(Company company);

    @Query("select count(rp) from RequestRecruit rp where rp.job.company=?1 and rp.status=?2")
    int getTotalRequestByCompanyAndStatus(Company company,Status status);

    boolean existsById(Long id);

    RequestRecruit getById(Long id);

    @Query("select rp from RequestRecruit rp where rp.user = ?1")
    List<RequestRecruit> findByUser(Users user, Pageable pageable);

    @Query("select count(rp) from RequestRecruit rp where rp.user=?1")
    int getTotalRequestByUser(Users user);
}
