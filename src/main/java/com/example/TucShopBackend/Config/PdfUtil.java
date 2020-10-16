package com.example.TucShopBackend.Config;


import com.example.TucShopBackend.Models.ProductTransaction;
import com.example.TucShopBackend.Models.Settings;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.Repositories.SettingsRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PdfUtil  {





}
