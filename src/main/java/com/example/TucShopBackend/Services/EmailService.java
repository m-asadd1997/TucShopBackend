package com.example.TucShopBackend.Services;


import com.example.TucShopBackend.DTO.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    private SimpleMailMessage simpleMailMessage;


    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(EmailDTO emailDTO, MultipartFile file) throws MailException {



        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(emailDTO.getEmail());
        mail.setSubject("Testing Mail API");
        mail.setText("Testing...");
        mail.setFrom("qureshiasad1000@gmail.com");




        javaMailSender.send(mail);
    }

    public void sendMail(String dear, String content) {

        MimeMessage message = javaMailSender.createMimeMessage();

        try{
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(simpleMailMessage.getFrom());
            helper.setTo(simpleMailMessage.getTo());
            helper.setSubject(simpleMailMessage.getSubject());
            helper.setText(String.format(
                    simpleMailMessage.getText(), dear, content));

            FileSystemResource file = new FileSystemResource("C:\\log.txt");
            helper.addAttachment(file.getFilename(), file);

        }catch (MessagingException e) {
            throw new MailParseException(e);
        }
        javaMailSender.send(message);
    }



}
