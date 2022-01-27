package com.example.job.services;

import com.example.job.entities.JobType;
import com.example.job.repositories.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobTypeService {
    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Transactional
    public List<JobType> getAll(){
        return jobTypeRepository.getAll();
    }

    @Transactional
    public JobType getById(Long id){
        return jobTypeRepository.getById(id);
    }
}
