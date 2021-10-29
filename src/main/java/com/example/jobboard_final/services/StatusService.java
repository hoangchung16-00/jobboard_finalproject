package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Status;
import com.example.jobboard_final.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;
    public Status getById(Long id){
        return statusRepository.getById(id);
    }
}
