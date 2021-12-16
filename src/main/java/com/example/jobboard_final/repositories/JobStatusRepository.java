package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface JobStatusRepository extends JpaRepository<JobStatus,Long> {
    @Query("select js from JobStatus js")
    List<JobStatus> getAll();

    JobStatus getById(Long id);
}
