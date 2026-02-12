package com.nesto.supermarket_app.service;

import com.nesto.supermarket_app.model.Admin;
import com.nesto.supermarket_app.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Look for the admin in the database by email
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Admin not found with email: " + email));

        // Return a Spring Security User object that contains the email and encoded password
        // The empty list at the end is for 'Roles/Authorities' (we can add these later)
        return new User(admin.getEmail(), admin.getPassword(), new ArrayList<>());
    }
}
