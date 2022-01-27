package com.example.job.services;

import com.example.job.entities.JobStatus;
import com.example.job.repositories.JobStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobStatusService {
    @Autowired
    private JobStatusRepository jobStatusRepository;

    @Transactional
    public List<JobStatus> getAll(){
        return jobStatusRepository.getAll();
    }

    @Transactional
    public JobStatus getById(Long id){
        return jobStatusRepository.getById(id);
    }
}
