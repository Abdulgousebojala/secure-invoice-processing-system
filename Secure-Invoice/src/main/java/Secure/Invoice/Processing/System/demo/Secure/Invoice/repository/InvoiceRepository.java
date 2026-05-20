package Secure.Invoice.Processing.System.demo.Secure.Invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    

}