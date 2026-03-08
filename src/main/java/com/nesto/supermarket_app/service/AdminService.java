package com.nesto.supermarket_app.service;

import com.nesto.supermarket_app.model.Admin;
import com.nesto.supermarket_app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveAdmin(Admin admin) {
        // Step 1: Encrypt the plain text password
        String encodedPassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodedPassword);

        // Step 2: Save the admin to the database
        adminRepository.save(admin);
    }

    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email).orElse(null);
    }
}
