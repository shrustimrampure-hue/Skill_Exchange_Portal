package com.cse.SkillExchangePortal.controller;

import com.cse.SkillExchangePortal.entity.Skill;
import com.cse.SkillExchangePortal.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillController {

    @Autowired
    private SkillService service;

    @GetMapping("/add-skill")
    public String addSkillPage() {
        return "addskill";
    }

    @PostMapping("/add-skill")
    public String saveSkill(Skill skill, Model model) {

        Skill savedSkill = service.addSkill(skill);

        if (savedSkill == null) {
            model.addAttribute("error", "Skill already exists!");
            return "addskill";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/browse-skills")
    public String browseSkills(Model model) {

        model.addAttribute("skills", service.getAllSkills());

        return "browseskills";
    }
    @GetMapping("/search-skills")
    public String searchSkills(@RequestParam String keyword,
                               Model model){

        model.addAttribute("skills",
                service.searchSkills(keyword));

        return "browseskills";
    }
}