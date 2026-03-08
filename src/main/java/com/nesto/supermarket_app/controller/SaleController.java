package com.nesto.supermarket_app.controller;

import com.nesto.supermarket_app.model.Product;
import com.nesto.supermarket_app.model.Sale;
import com.nesto.supermarket_app.model.SaleItem;
import com.nesto.supermarket_app.repository.CustomerRepository;
import com.nesto.supermarket_app.repository.ProductRepository;
import com.nesto.supermarket_app.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sales")
public class SaleController {

    @Autowired private SaleRepository saleRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private ProductRepository productRepository;

    @GetMapping
    public String listSales(Model model) {
        model.addAttribute("sales", saleRepository.findAll());
        return "sale-list";
    }

    @GetMapping("/add")
    public String showSaleForm(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "sale-form";
    }

    @PostMapping("/save")
    public String saveSale(@RequestParam Long customerId,
                           @RequestParam Long[] productIds,
                           @RequestParam Integer[] quantities) {

        Sale sale = new Sale();
        sale.setCustomer(customerRepository.findById(customerId).orElse(null));

        double grandTotal = 0.0;
        List<SaleItem> items = new ArrayList<>();

        for (int i = 0; i < productIds.length; i++) {
            Product p = productRepository.findById(productIds[i]).orElse(null);
            if (p != null) {
                SaleItem item = new SaleItem();
                item.setProduct(p);
                item.setQuantity(quantities[i]);
                item.setUnitPrice(p.getPrice());
                item.setSubtotal(p.getPrice() * quantities[i]);
                item.setSale(sale);

                items.add(item);
                grandTotal += item.getSubtotal();
            }
        }

        sale.setItems(items);
        sale.setTotalBill(grandTotal);
        Sale savedSale = saleRepository.save(sale);

        // Redirect to the invoice view of the newly created sale
        return "redirect:/sales/invoice/" + savedSale.getId();
    }

    @GetMapping("/invoice/{id}")
    public String viewInvoice(@PathVariable Long id, Model model) {
        Sale sale = saleRepository.findById(id).orElse(null);
        model.addAttribute("sale", sale);
        return "invoice";
    }

    @GetMapping("/report/download")
    public void exportToPDF(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=Nesto_Sales_Report.pdf");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);

        Paragraph p = new Paragraph("Nesto Supermarket Sales Report", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(10);

        // Table Headers
        table.addCell("ID");
        table.addCell("Customer");
        table.addCell("Date");
        table.addCell("Total Amount");

        List<Sale> listSales = saleRepository.findAll();
        for (Sale sale : listSales) {
            table.addCell(String.valueOf(sale.getId()));
            table.addCell(sale.getCustomer().getName());
            table.addCell(sale.getSaleDate().toString());
            table.addCell("Rs. " + sale.getTotalBill());
        }

        document.add(table);
        document.close();
    }
}