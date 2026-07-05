package com.cse.SkillExchangePortal.service;

import com.cse.SkillExchangePortal.entity.Skill;
import com.cse.SkillExchangePortal.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository repository;

    public Skill addSkill(Skill skill) {

        Skill existingSkill =
                repository.findBySkillNameIgnoreCase(skill.getSkillName());

        if (existingSkill != null) {
            return null;   // Skill already exists
        }

        return repository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return repository.findAll();
    }

    public List<Skill> searchSkills(String keyword) {
        return repository.findBySkillNameContainingIgnoreCase(keyword);
    }

    // New method
    public Skill getSkillById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}