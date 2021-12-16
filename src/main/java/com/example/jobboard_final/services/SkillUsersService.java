package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.SkillUsers;
import com.example.jobboard_final.entities.Users;
import com.example.jobboard_final.repositories.SkillUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
public class SkillUsersService {
    @Autowired
    private SkillUsersRepository skillUsersRepository;

    @Transactional
    public SkillUsers getById(Long id){
        return skillUsersRepository.getById(id);
    }

    @Transactional
    public List<SkillUsers> findByUsersId(Long id){
        return skillUsersRepository.findByUsersId(id);
    }

    @Transactional
    public void addSkill(SkillUsers skillUsers){
        skillUsersRepository.save(skillUsers);
    }

    @Transactional
    public void editListSkill(List<Long> ids,List<String> names,List<String> experiences){
        for (int i = 0 ; i<ids.size() ; i++) {
            SkillUsers skillUsers = skillUsersRepository.getById(ids.get(i));
            skillUsers.setName(names.get(i));
            skillUsers.setExperience(experiences.get(i));
            skillUsersRepository.save(skillUsers);
        }
    }

    @Transactional
    public void removeSkill(SkillUsers skillUsers){
        skillUsersRepository.delete(skillUsers);
    }

    @Transactional
    public boolean existById(Long id){
        return skillUsersRepository.existsById(id);
    }
}
