package com.example.job.repositories;

import com.example.job.entities.SkillUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillUsersRepository extends JpaRepository<SkillUsers, Long> {
    @Query("select su from SkillUsers su where su.user.id = ?1")
    List<SkillUsers> findByUsersId(Long id);

    SkillUsers getById(Long id);

    boolean existsById(Long id);
}
