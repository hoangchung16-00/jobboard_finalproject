package com.example.job.services;

import com.example.job.entities.Status;
import com.example.job.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;
    @Transactional
    public Status getById(Long id){
        return statusRepository.getById(id);
    }
    @Transactional
    public List<Status> getAll(){
        return statusRepository.getAll();
    }
    @Transactional
    public Status getByName(String name){
        return statusRepository.getByName(name);
    }
}
