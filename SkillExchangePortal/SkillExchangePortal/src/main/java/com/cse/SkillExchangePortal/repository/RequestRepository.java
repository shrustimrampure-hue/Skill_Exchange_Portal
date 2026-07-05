package com.cse.SkillExchangePortal.repository;

import com.cse.SkillExchangePortal.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findByRequesterEmail(String requesterEmail);

    Request findByRequesterEmailAndSkillId(String requesterEmail, Integer skillId);

}