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
        model.addAttribute("admin", new Admin());
        return "signup";
    }

    // 2. Handle the Form Submission with Duplicate Check
    @PostMapping("/register")
    public String registerAdmin(@ModelAttribute("admin") Admin admin, Model model) {

        // CHECK: Does this email already exist in the database?
        // Note: Make sure you have findByEmail defined in your Service/Repository
        Admin existingAdmin = adminService.findByEmail(admin.getEmail());

        if (existingAdmin != null) {
            // If email exists, add error message and return to signup page
            model.addAttribute("error", "Email already registered. Please login.");
            return "signup";
        }

        // If no duplicate, save and redirect
        adminService.saveAdmin(admin);
        return "redirect:/login?success";
    }

    // 3. Show the Login Page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
}
