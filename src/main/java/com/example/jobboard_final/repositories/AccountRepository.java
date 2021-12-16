package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("select a from Account a")
    List<Account> getAccounts();

    Account findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByVerificationcode(String verficationcode);
    Account findByVerificationcode(String verificationcode);

}
