package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AccountRoleRepository extends JpaRepository<AccountRole,Long> {

    List<AccountRole> findAll();
    @Query("select ar from AccountRole ar where ar.id=?1 ")
    AccountRole getById(Long id);

    AccountRole getByName(String name);
}
