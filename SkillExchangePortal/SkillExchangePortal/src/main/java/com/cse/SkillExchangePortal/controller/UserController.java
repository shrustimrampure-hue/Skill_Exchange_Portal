package com.cse.SkillExchangePortal.controller;
import org.springframework.ui.Model;
import com.cse.SkillExchangePortal.entity.User;
import com.cse.SkillExchangePortal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public String registerUser(User user) {

        service.registerUser(user);

        return "redirect:/login";
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String email,
                            @RequestParam String password,
                            HttpSession session,
                            Model model) {

        User user = service.login(email);

        if (user == null) {
            model.addAttribute("error", "User not found! Please sign up first.");
            return "login";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Invalid password.");
            return "login";
        }

        session.setAttribute("loggedInUser", user);

        return "redirect:/dashboard";
    }
    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        model.addAttribute("user", user);

        return "profile";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/login";
    }
}