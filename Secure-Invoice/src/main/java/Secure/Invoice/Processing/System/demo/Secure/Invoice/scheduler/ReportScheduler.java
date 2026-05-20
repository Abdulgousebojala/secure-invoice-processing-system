package Secure.Invoice.Processing.System.demo.Secure.Invoice.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.service.EmailService;
import Secure.Invoice.Processing.System.demo.Secure.Invoice.service.ExcelReportService;

@Component
public class ReportScheduler {

    @Autowired
    private ExcelReportService excelReportService;

    @Autowired
    private EmailService emailService;

    
    @Scheduled(cron = "*/30 * * * * ?")
    public void generateInvoiceReport() {

        try {

            System.out.println(
                    "Scheduler Started..."
            );

            // Generate Excel Report
            excelReportService.generateExcelReport();

            // Send Email With Excel Attachment
            emailService.sendEmailWithAttachment(
                    "abdulgousebojala@gmail.com",
                    "Invoice Report",
                    "Invoice report generated successfully",
                    "invoice-report.xlsx"
            );

            System.out.println(
                    "Scheduler Finished Successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}