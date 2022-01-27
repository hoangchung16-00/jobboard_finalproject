package com.example.job.repositories;

import com.example.job.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Status getById(Long id);

    @Query("select s from Status s")
    List<Status> getAll();

    Status getByName(String name);
}
