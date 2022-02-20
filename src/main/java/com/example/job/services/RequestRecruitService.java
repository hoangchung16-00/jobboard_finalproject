package com.example.job.services;

import com.example.job.entities.*;
import com.example.job.repositories.RequestRecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
        requestRecruitRepository.save(new RequestRecruit(job,users,status,new Date()));
        if(requestRecruitRepository.existsByUserAndJob(users.getId(),job.getId())){
            return true;
        }
        return false;
    }

    @Transactional
    public List<RequestRecruit> findByCompanyAndStatus(Company company,Status status, Pageable pageable){
        return requestRecruitRepository.findByCompanyAndStatus(company,status,pageable);
    }

    @Transactional
    public List<RequestRecruit> findByCompany(Company company, Pageable pageable){
        return requestRecruitRepository.findByCompany(company,pageable);
    }

    @Transactional
    public int getTotalRequestByCompany(Company company){
        return requestRecruitRepository.getTotalRequestByCompany(company);
    }

    @Transactional
    public int getTotalRequestByCompanyAndStatus(Company company,Status status){
        return requestRecruitRepository.getTotalRequestByCompanyAndStatus(company,status);
    }

    @Transactional
    public boolean existsById(Long id){
        return requestRecruitRepository.existsById(id);
    }

    @Transactional
    public RequestRecruit getById(Long id){
        RequestRecruit requestRecruit = requestRecruitRepository.getById(id);
        requestRecruit.getJob();
        return requestRecruit;
    }

    @Transactional
    public void setRequestStatus(Long id,Status status){
        RequestRecruit request = requestRecruitRepository.getById(id);
        request.setStatus(status);
        requestRecruitRepository.save(request);
    }

    @Transactional
    public List<RequestRecruit> findByUser(Users user, Pageable pageable){
        return requestRecruitRepository.findByUser(user,pageable);
    }

    @Transactional
    public int getTotalRequestByUser(Users users){
        return requestRecruitRepository.getTotalRequestByUser(users);
    }
}
