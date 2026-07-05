package com.cse.SkillExchangePortal.service;

import com.cse.SkillExchangePortal.entity.Request;
import com.cse.SkillExchangePortal.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository repository;

    public Request saveRequest(Request request) {

        Request existing = repository.findByRequesterEmailAndSkillId(
                request.getRequesterEmail(),
                request.getSkillId());

        if (existing != null) {
            return null;
        }

        return repository.save(request);
    }
    public Request getRequestById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void updateRequest(Request request){
        repository.save(request);
    }

    public List<Request> getAllRequests() {
        return repository.findAll();
    }

}