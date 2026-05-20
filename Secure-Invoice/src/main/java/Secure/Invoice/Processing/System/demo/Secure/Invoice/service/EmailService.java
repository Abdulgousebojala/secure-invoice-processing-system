package Secure.Invoice.Processing.System.demo.Secure.Invoice.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailWithAttachment(
            String toEmail,
            String subject,
            String body,
            String filePath) {

        try {

            MimeMessage message =
                    mailSender.createMimeMessage();

            MimeMessageHelper helper =
                    new MimeMessageHelper(message, true);

            helper.setTo(toEmail);

            helper.setSubject(subject);

            helper.setText(body);

            FileSystemResource file =
                    new FileSystemResource(
                            new File(filePath)
                    );

            helper.addAttachment(
                    file.getFilename(),
                    file
            );

            mailSender.send(message);

            System.out.println(
                    "Email Sent Successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}