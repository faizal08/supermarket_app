package com.nesto.supermarket_app.repository;

import com.nesto.supermarket_app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
