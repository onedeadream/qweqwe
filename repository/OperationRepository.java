package com.Obrabotka.IT.repository;

import com.Obrabotka.IT.models.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Operation findByData(String data);
}
