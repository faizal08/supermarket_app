package com.nesto.supermarket_app.repository;

import com.nesto.supermarket_app.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    // Custom query to find admin during login
    Optional<Admin> findByEmail(String email);
}
