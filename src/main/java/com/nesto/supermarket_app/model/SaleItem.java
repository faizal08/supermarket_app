package com.nesto.supermarket_app.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SaleItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @ManyToOne
    private Product product;

    private int quantity;
    private Double unitPrice;
    private Double subtotal; // price * quantity
}
