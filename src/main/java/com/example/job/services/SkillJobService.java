package com.example.job.services;

import com.example.job.entities.SkillJob;
import com.example.job.repositories.SkillJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkillJobService {
    @Autowired
    private SkillJobRepository skillJobRepository;

    @Transactional
    public void addSKillJobList(List<SkillJob> skillJobList){
        for (SkillJob skillJob : skillJobList ) {
            skillJobRepository.save(new SkillJob(skillJob.getName(),skillJob.getLevelType(),skillJob.getJob()));
        }
    }
}
