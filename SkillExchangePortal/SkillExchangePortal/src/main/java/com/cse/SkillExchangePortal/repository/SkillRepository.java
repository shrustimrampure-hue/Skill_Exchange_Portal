package com.cse.SkillExchangePortal.repository;

import com.cse.SkillExchangePortal.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

    List<Skill> findBySkillNameContainingIgnoreCase(String skillName);

    Skill findBySkillNameIgnoreCase(String skillName);

}