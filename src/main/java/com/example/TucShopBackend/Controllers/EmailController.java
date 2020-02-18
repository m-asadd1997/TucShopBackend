package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CategoryDTO;
import com.example.TucShopBackend.DTO.EmailDTO;
import com.example.TucShopBackend.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/sendemail")
    public String send(@RequestBody EmailDTO emailDTO) {

        try {
            emailService.sendEmail(emailDTO);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }


//    @PostMapping("/")
//    public ApiResponse addCategory(@Valid @RequestParam("file") MultipartFile file, EmailDTO emailDTO) {
//
//            emailDTO.setEmail(file);
//
//    }
}


