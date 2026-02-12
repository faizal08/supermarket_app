package com.nesto.supermarket_app.controller;

import com.nesto.supermarket_app.model.Admin;
import com.nesto.supermarket_app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 1. Show the Signup Page
    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        // We send an empty Admin object to the frontend to hold the form data
        model.addAttribute("admin", new Admin());
        return "signup"; // This refers to signup.html in templates folder
    }

    // 2. Handle the Form Submission
    @PostMapping("/register")
    public String registerAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/login?success"; // After signup, send them to login
    }

    // 3. Show the Login Page (We will create this next)
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}
