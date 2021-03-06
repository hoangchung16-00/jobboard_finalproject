package com.example.job.repositories;

import com.example.job.entities.Users;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Long> {
    @Query("select u from Users u")
    List<Users> getUsers(Pageable pageable);
    @Query("select count(u) from Users u")
    int getTotalUser();
    boolean existsById(Long id);
    boolean existsByIdsocial(String id);
    Users findUsersById(Long id);
    @Query("select u from Users u")
    List<Users> getUsers();
    Users findByIdsocial(String id);
    boolean existsByEmail(String email);
}
