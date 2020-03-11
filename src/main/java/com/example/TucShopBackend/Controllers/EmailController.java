package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.DTO.EmailDTO;
import com.example.TucShopBackend.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
@RequestMapping("/api/email")

public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public String send(@RequestBody EmailDTO emailDTO, MultipartFile file) {

        try {
            emailService.sendEmail(emailDTO, file);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }



}
