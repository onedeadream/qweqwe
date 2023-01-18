package com.Obrabotka.IT.repository;

import com.Obrabotka.IT.models.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Requests, Long> {
}
