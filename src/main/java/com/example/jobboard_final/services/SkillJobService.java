package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.SkillJob;
import com.example.jobboard_final.repositories.SkillJobRepository;
import com.example.jobboard_final.repositories.SkillUsersRepository;
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
