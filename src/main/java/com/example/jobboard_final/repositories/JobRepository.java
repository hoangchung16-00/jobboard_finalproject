package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Job;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface JobRepository extends JpaRepository<Job,Long> {
    @Query("select j from Job j order by j.postdate desc ")
    List<Job> getJobs(Pageable pageable);
    @Query("select count(j) from Job j")
    int getTotalJob();
    Job getJobById(Long id);
    boolean existsById(Long id);
}
