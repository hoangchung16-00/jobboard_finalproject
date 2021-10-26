package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select j from Job j")
    List<Job> getJobs(Pageable pageable);
    @Query("select count(j) from Job j")
    int getTotalJob();

}
