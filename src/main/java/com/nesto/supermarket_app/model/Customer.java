package com.nesto.supermarket_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email; // Replaced 'address' with 'email'

    @Column(unique = true)
    private String mobile;

    // Note: I removed 'age' to stay consistent with your 'customer-list.html'
    // and 'customer-form.html' which focus on contact details.
}
