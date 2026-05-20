package Secure.Invoice.Processing.System.demo.Secure.Invoice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.Invoice;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.repository.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Create Invoice
    public Invoice createInvoice(Invoice invoice) {

        invoice.setCreatedAt(LocalDateTime.now());

        return invoiceRepository.save(invoice);
    }

    // Get All Invoices
    public List<Invoice> getAllInvoices() {

        return invoiceRepository.findAll();
    }

    // Get Invoice By Id
    public Invoice getInvoiceById(Long id) {

        return invoiceRepository.findById(id).orElse(null);
    }

    // Delete Invoice
    public String deleteInvoice(Long id) {
        
        invoiceRepository.deleteById(id);

        return "Invoice Deleted Successfully";
    }
}