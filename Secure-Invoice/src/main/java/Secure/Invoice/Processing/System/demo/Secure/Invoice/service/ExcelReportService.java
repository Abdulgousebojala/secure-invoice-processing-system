package Secure.Invoice.Processing.System.demo.Secure.Invoice.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.Invoice;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.repository.InvoiceRepository;

@Service
public class ExcelReportService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public void generateExcelReport() {

        List<Invoice> invoices = invoiceRepository.findAll();

        try {

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet =
                    workbook.createSheet("Invoices");

            // Header Row
            Row headerRow = sheet.createRow(0);

            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Customer Name");
            headerRow.createCell(2).setCellValue("Customer Email");
            headerRow.createCell(3).setCellValue("Amount");
            headerRow.createCell(4).setCellValue("Status");
            headerRow.createCell(5).setCellValue("Created At");

            int rowNum = 1;

            // Data Rows
            for (Invoice invoice : invoices) {

                Row row = sheet.createRow(rowNum++);

                row.createCell(0)
                        .setCellValue(invoice.getId());

                row.createCell(1)
                        .setCellValue(invoice.getCustomerName());

                row.createCell(2)
                        .setCellValue(invoice.getCustomerEmail());

                row.createCell(3)
                        .setCellValue(invoice.getAmount());

                row.createCell(4)
                        .setCellValue(invoice.getStatus());

                row.createCell(5)
                        .setCellValue(
                                invoice.getCreatedAt().toString()
                        );
            }

            // Save Excel File
            FileOutputStream outputStream =
                    new FileOutputStream(
                            "invoice-report.xlsx"
                    );

            workbook.write(outputStream);

            workbook.close();

            outputStream.close();

            System.out.println(
                    "Excel Report Generated Successfully"
            );

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}