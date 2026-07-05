package com.cse.SkillExchangePortal.controller;

import com.cse.SkillExchangePortal.entity.Request;
import com.cse.SkillExchangePortal.entity.Skill;
import com.cse.SkillExchangePortal.entity.User;
import com.cse.SkillExchangePortal.service.RequestService;
import com.cse.SkillExchangePortal.service.SkillService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RequestController {

    @Autowired
    private RequestService service;

    @Autowired
    private SkillService skillService;

    @PostMapping("/request-skill")
    public String requestSkill(@RequestParam Integer skillId,
                               HttpSession session,
                               Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Skill skill = skillService.getSkillById(skillId);

        Request request = new Request();
        request.setSkillId(skillId);
        request.setSkillName(skill.getSkillName());
        request.setRequesterEmail(user.getEmail());
        request.setStatus("Pending");

        Request saved = service.saveRequest(request);

        if (saved == null) {
            model.addAttribute("error", "You have already requested this skill.");
            model.addAttribute("requests", service.getAllRequests());
            return "requests";
        }

        return "redirect:/requests";
    }

    @GetMapping("/requests")
    public String requests(Model model) {

        model.addAttribute("requests", service.getAllRequests());

        return "requests";
    }

    @GetMapping("/approve/{id}")
    public String approveRequest(@PathVariable Integer id,
                                 RedirectAttributes redirectAttributes) {

        Request request = service.getRequestById(id);

        if (request != null) {
            request.setStatus("Approved");
            service.updateRequest(request);

            redirectAttributes.addFlashAttribute(
                    "success",
                    "Request Approved Successfully!"
            );
        }

        return "redirect:/requests";
    }

    @GetMapping("/reject/{id}")
    public String rejectRequest(@PathVariable Integer id,
                                RedirectAttributes redirectAttributes) {

        Request request = service.getRequestById(id);

        if (request != null) {
            request.setStatus("Rejected");
            service.updateRequest(request);

            redirectAttributes.addFlashAttribute(
                    "error",
                    "Request has been rejected."
            );
        }

        return "redirect:/requests";
    }
}