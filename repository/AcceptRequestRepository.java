package com.Obrabotka.IT.repository;

import com.Obrabotka.IT.models.AcceptRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptRequestRepository extends JpaRepository<AcceptRequest, Long> {
}
