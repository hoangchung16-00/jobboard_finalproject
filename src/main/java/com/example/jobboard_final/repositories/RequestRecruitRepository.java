package com.example.jobboard_final.repositories;

import com.example.jobboard_final.entities.RequestRecruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestRecruitRepository extends JpaRepository<RequestRecruit,Long> {
    @Query("select (count(rp) > 0) from RequestRecruit rp where rp.user.id=?1 and rp.job.id=?2")
    boolean existsByUserAndJob(Long userId,Long jobId);
}
