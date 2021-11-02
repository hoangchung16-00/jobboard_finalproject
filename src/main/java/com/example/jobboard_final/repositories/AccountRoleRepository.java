package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.AccountRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleRepository extends JpaRepository<AccountRole,Long> {
    AccountRole getById(Long id);
}
