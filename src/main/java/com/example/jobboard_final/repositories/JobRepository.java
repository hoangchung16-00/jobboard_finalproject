package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select j from Job j order by j.postdate desc ")
    List<Job> getJobs(Pageable pageable);

    @Query("select count(j) from Job j")
    int getTotalJob();

    Job getJobById(Long id);
    boolean existsById(Long id);

    @Query("select j from Job j,SkillJob sj where j.id = sj.job.id and (lower(j.name) like %:keyword% or lower(j.jobType.name) like %:keyword% or lower(sj.levelType.name) like %:keyword% or lower(j.description) like %:keyword% or lower(j.company.name) like %:keyword% or lower(j.address) like %:keyword% or lower(sj.name) like %:keyword% )")
    List<Job> findJobByKeyword(@Param("keyword") String keyword,Pageable pageable);

    @Query("select count(j) from Job j,SkillJob sj where j.id = sj.job.id and (lower(j.name) like %:keyword% or lower(j.jobType.name) like %:keyword% or lower(sj.levelType.name) like %:keyword% or lower(j.description) like %:keyword% or lower(j.company.name) like %:keyword% or lower(j.address) like %:keyword% or lower(sj.name) like %:keyword% )")
    int getTotalJobByKeyword(@Param("keyword") String keyword);

}
