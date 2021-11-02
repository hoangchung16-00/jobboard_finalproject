package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.Job;
import com.example.jobboard_final.entities.RequestRecruit;
import com.example.jobboard_final.entities.Status;
import com.example.jobboard_final.entities.Users;
import com.example.jobboard_final.repositories.RequestRecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RequestRecruitService {
    @Autowired
    private RequestRecruitRepository requestRecruitRepository;

    @Transactional
    public boolean existByUserAndJob(Long userId,Long jobId){
        return requestRecruitRepository.existsByUserAndJob(userId,jobId);
    }
    @Transactional
    public boolean existByUserAndJob(String userId,Long jobId){
        return requestRecruitRepository.existsByUserAndJob(userId,jobId);
    }
    @Transactional
    public boolean apply(Job job , Users users, Status status){
        requestRecruitRepository.save(new RequestRecruit(job,users,status));
        if(requestRecruitRepository.existsByUserAndJob(users.getId(),job.getId())){
            return true;
        }
        return false;
    }
}
