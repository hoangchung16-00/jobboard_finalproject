package com.example.job.services;

import com.example.job.entities.*;
import com.example.job.forms.JobForm;
import com.example.job.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class JobServices {
    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public List<Job> getJobs(Pageable pageable){
        List<Job> jobs = jobRepository.getJobs(pageable);
        for (Job job: jobs) {
            job.getSkillJobList().size();
        }
        return jobs;
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

    @Transactional
    public List<Job> findJobByKeyword(String keyword, List<Long> filter, Pageable pageable){
        List<Job> jobs = jobRepository.findJobByKeyword(keyword,filter,pageable);
        for (Job job : jobs) {
            job.getSkillJobList().size();

        }
        return jobs;
    }

    @Transactional
    public int getTotalJobByKeyword(String keyword,List<Long> filter){
        return jobRepository.getTotalJobByKeyword(keyword,filter);
    }

    @Transactional
    public Job createJob(JobForm jobForm, JobStatus jobStatus, Company company, JobType jobType) throws ParseException {
        String sDate= jobForm.getExpiredate();
        Date date=new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
        Job job = new Job(jobForm.getName(),jobForm.getShortdescription(),jobForm.getDescription(),jobForm.getAddress(),jobForm.getNumber(),jobForm.getMinsalary(),jobForm.getMaxsalary(),date,new Date(),jobForm.getBenefit(),jobStatus,company,jobType);
        return jobRepository.save(job);
    }

    @Transactional
    public List<Job> getJobsByFilter(List<Long> filter, Pageable pageable){
        List<Job> jobs = jobRepository.getJobsByFilter(filter,pageable);
        for (Job job : jobs) {
            job.getSkillJobList().size();
        }
        return jobs;
    }

    @Transactional
    public int getTotalJobByFilter(List<Long> filter){
        return jobRepository.getTotalJobByFilter(filter);
    }

    @Transactional
    public List<Job> getJobsByCompany(Long id,Pageable pageable){
        return jobRepository.getJobsByCompany(id,pageable);
    }

    @Transactional
    public int getTotalJobByCompany(Long id){
        return jobRepository.getTotalJobByCompany(id);
    }
}
