package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Status getById(Long id);
}
