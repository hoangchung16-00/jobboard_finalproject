package com.example.job.repositories;

import com.example.job.entities.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
    @Query("select jt from JobType jt")
    List<JobType> getAll();

    JobType getById(Long id);
}
