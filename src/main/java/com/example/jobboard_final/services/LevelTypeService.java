package com.example.jobboard_final.services;

import com.example.jobboard_final.entities.LevelType;
import com.example.jobboard_final.repositories.LevelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Level;
import java.util.List;
@Service
public class LevelTypeService {
    @Autowired
    private LevelTypeRepository levelTypeRepository;

    @Transactional
    public List<LevelType> findAll(){
        return levelTypeRepository.findAll();
    }

    @Transactional
    public LevelType getById(Long id){
        return levelTypeRepository.getById(id);
    }
}
