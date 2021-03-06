package com.example.job.repositories;

import com.example.job.entities.Company;
import com.example.job.entities.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select j from Job j order by j.postdate desc ")
    List<Job> getJobs(Pageable pageable);

    @Query("select count(j) from Job j")
    int getTotalJob();

    Job getJobById(Long id);
    boolean existsById(Long id);

    @Query("select j from Job j,SkillJob sj where (lower(j.name) like %:keyword% or lower(j.jobType.name) like %:keyword% or lower(sj.levelType.name) like %:keyword% or lower(j.description) like %:keyword% or lower(j.company.name) like %:keyword% or lower(j.address) like %:keyword% or lower(sj.name) like %:keyword%) and (j.jobType.id in :filter) order by j.postdate desc")
    List<Job> findJobByKeyword(@Param("keyword") String keyword, @Param("filter") List<Long> filter, Pageable pageable);

    @Query("select count(j) from Job j,SkillJob sj where (lower(j.name) like %:keyword% or lower(j.jobType.name) like %:keyword% or lower(sj.levelType.name) like %:keyword% or lower(j.description) like %:keyword% or lower(j.company.name) like %:keyword% or lower(j.address) like %:keyword% or lower(sj.name) like %:keyword% ) and j.jobType.id in :filter")
    int getTotalJobByKeyword(@Param("keyword") String keyword, @Param("filter") List<Long> filter);

    @Query("select j from Job j where j.jobType.id in :filter order by j.postdate desc ")
    List<Job> getJobsByFilter(@Param("filter") List<Long> filter, Pageable pageable);

    @Query("select count(j) from Job j where j.jobType.id in :filter")
    int getTotalJobByFilter(@Param("filter") List<Long> filter);

    @Query("select j from Job j where j.company.id = ?1")
    List<Job> getJobsByCompany(Long id,Pageable pageble);

    @Query("select count(j) from Job j where j.company.id = ?1")
    int getTotalJobByCompany(Long id);
}
