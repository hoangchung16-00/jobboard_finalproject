package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Job;
import com.example.jobboard_final.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class JobServices {
    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public List<Job> getJobs(Pageable pageable){
        return jobRepository.getJobs(pageable);
    }
    @Transactional
    public int getTotalJob(){
        return  jobRepository.getTotalJob();
    }
    @Transactional
    public Job getJobById(Long id){
        Job job = jobRepository.getJobById(id);
        job.getSkillJobList().size();
        return job;
    }
    @Transactional
    public boolean existsById(Long id){
        return jobRepository.existsById(id);
    }
}
