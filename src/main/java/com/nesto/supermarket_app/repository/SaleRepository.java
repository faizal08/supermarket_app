package com.nesto.supermarket_app.repository;

import com.nesto.supermarket_app.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}