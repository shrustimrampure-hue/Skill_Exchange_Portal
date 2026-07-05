package com.cse.SkillExchangePortal.controller;

import com.cse.SkillExchangePortal.entity.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);

        return "dashboard";
    }

}