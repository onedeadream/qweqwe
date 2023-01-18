package com.Obrabotka.IT.service;

import com.Obrabotka.IT.models.Operation;
import com.Obrabotka.IT.models.Requests;
import com.Obrabotka.IT.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepository;

    public List<Requests> findAllRequest() {
        return requestRepository.findAll();
    }

    public boolean deleteReq(Long requestId) {
        if (requestRepository.findById(requestId).isPresent()) {
            requestRepository.deleteById(requestId);
            return true;
        }
        return false;
    }
}
