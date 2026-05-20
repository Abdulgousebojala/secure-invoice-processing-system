package Secure.Invoice.Processing.System.demo.Secure.Invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SecureInvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureInvoiceApplication.class, args);
	}

}
