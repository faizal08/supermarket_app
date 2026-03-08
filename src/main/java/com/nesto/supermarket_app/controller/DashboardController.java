package com.nesto.supermarket_app.controller;

import com.nesto.supermarket_app.model.Sale;
import com.nesto.supermarket_app.repository.CustomerRepository;
import com.nesto.supermarket_app.repository.ProductRepository;
import com.nesto.supermarket_app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private SaleRepository saleRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // 1. Get real counts for the cards
        model.addAttribute("totalCustomers", customerRepository.count());
        model.addAttribute("totalProducts", productRepository.count());

        // 2. Calculate Total Revenue
        List<Sale> allSales = saleRepository.findAll();
        double totalRevenue = allSales.stream().mapToDouble(Sale::getTotalBill).sum();
        model.addAttribute("totalRevenue", totalRevenue);

        return "dashboard";
    }
}
