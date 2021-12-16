package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.LevelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface LevelTypeRepository extends JpaRepository<LevelType,Long> {
    List<LevelType> findAll();

    @Query("select lt from LevelType lt where lt.id=?1")
    LevelType getById(Long id);
}
