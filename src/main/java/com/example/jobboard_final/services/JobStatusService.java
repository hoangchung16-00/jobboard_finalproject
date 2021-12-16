package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.JobStatus;
import com.example.jobboard_final.repositories.JobStatusRepository;
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
