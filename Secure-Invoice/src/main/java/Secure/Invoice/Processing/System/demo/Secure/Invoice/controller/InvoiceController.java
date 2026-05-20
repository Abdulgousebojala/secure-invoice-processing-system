package Secure.Invoice.Processing.System.demo.Secure.Invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.Invoice;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Create Invoice
    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {

        return invoiceService.createInvoice(invoice);
    }

    // Get All Invoices
    @GetMapping
    public List<Invoice> getAllInvoices() {

        return invoiceService.getAllInvoices();
    }

    // Get Invoice By Id
    @GetMapping("/{id}")
    public Invoice getInvoiceById(@PathVariable Long id) {

        return invoiceService.getInvoiceById(id);
    }

    // Delete Invoice
    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id) {

        return invoiceService.deleteInvoice(id);
    }
}