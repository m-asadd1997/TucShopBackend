package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.ChartDataDTO;
import com.example.TucShopBackend.DTO.SettingsDTO;
import com.example.TucShopBackend.Models.Products;
import com.example.TucShopBackend.Models.Settings;
import com.example.TucShopBackend.Models.Transactions;
import com.example.TucShopBackend.DTO.RequestForProductDTO;
import com.example.TucShopBackend.Models.RequestForProduct;
import com.example.TucShopBackend.Repositories.ProductsRepository;
import com.example.TucShopBackend.Repositories.RequestForProductRepository;
import com.example.TucShopBackend.Repositories.SettingsRepository;
import com.example.TucShopBackend.Repositories.TransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

/**
 * Created by Hassan on 2/12/2020.
 */
@Service
public class DashboardService {

    @Autowired
    ProductsService productsService;

    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    TransactionsRepository transactionsRepository;
    @Autowired
    RequestForProductRepository requestForProductRepository;
    @Autowired
    SettingsRepository settingsRepository;

    public ApiResponse productsQuantity() {
        return new ApiResponse(Status.Status_Ok, "Sucessfully fetch total products", productsRepository.productQauntity());
    }

    public ApiResponse productQuantityDetails() {
        return new ApiResponse(Status.Status_Ok, "Total products Details", productsRepository.productQauntityDetails());
    }

    public ApiResponse outOfStockProductsDetails() {
        return new ApiResponse(Status.Status_Ok, "Out of Stock Products", productsRepository.outOfStockProducts());
    }

    public ApiResponse outOfStockProducts() {
        return new ApiResponse(Status.Status_Ok, "Out of Stock", productsRepository.outOfStockCount());
    }

    public ApiResponse totalTransaction() {
        return new ApiResponse(Status.Status_Ok, "Successfully fetch Total Transation", transactionsRepository.getTotalTransaction());
    }

    public ApiResponse transactionDetails() {
        return new ApiResponse(Status.Status_Ok, "Get Transaction Details", transactionsRepository.getTransactionDetails());
    }


    public ApiResponse requestedProductsKeyword(String keyword) {
        List<RequestForProductDTO> topRequestedProductsKeyword = requestForProductRepository.topRequestedProductsKeyword(keyword);
        return new ApiResponse(Status.Status_Ok, "Successfully keyword Match From requested Products", topRequestedProductsKeyword);
    }

    public ApiResponse requestedProductsCount() {
        List<RequestForProductDTO> topRequestedProductsCount = requestForProductRepository.topRequestedProductsCount();

        return new ApiResponse(Status.Status_Ok, "Successfully get top requested Products Count", topRequestedProductsCount);
    }


    public ApiResponse getMonthlySales() {
        List<LocalDate> dates = new ArrayList<>();
        List<Double> seperateAmounts= new ArrayList<>();
        String monthName = "";
        Map<String, Double> map = new HashMap<>();
        List<Transactions> transactionsList = transactionsRepository.findAll();
        for (Transactions transaction : transactionsList) {
            monthName = transaction.getDate().getMonth().toString();
            if (!map.containsKey(monthName)) {
                map.put(monthName, transaction.getAmount());
            }
            else {
                map.put(monthName, map.get(monthName).doubleValue() + transaction.getAmount());
            }
            dates.add(transaction.getDate());
            seperateAmounts.add(transaction.getAmount());

        }

        System.out.println(map);
        ChartDataDTO cdt = new ChartDataDTO();
        List<String> labelList = new ArrayList<>();
        List<Double> seriesList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {

            labelList.add(entry.getKey());
            seriesList.add(entry.getValue());
        }

        if (labelList != null && seriesList != null&&dates!=null) {
            cdt.setLabels(labelList);
            cdt.setSeries(seriesList);
            cdt.setDates(dates);
            cdt.setAmounts(seperateAmounts);
        }

        return new ApiResponse(Status.Status_Ok, "Get Sales per month", cdt);


    }

    @Value("${logo.image.url}")
    String settingLogoUrl;

    public ApiResponse postSettings(SettingsDTO settingsDTO) {

        Settings settingsHeader = settingsRepository.findSettingByHeaderAndFooter(settingsDTO.getHeader(), settingsDTO.getFooter());

        if (settingsHeader != null) {

            return new ApiResponse(Status.Status_DUPLICATE, CustomConstants.Setting_DUPLICATE, settingsHeader);

        }

            else {
                settingsRepository.deleteAll();
                String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

                if (saveSettingslogo(settingsDTO.getLogo(), settingsDTO.getHeaderName(), unique)) {
                    Settings settings = new Settings();
                    settings.setLogo(settingLogoUrl + settingsDTO.getHeaderName() + "/" + unique + settingsDTO.getLogo().getOriginalFilename());
                    settings.setHeaderName(settingsDTO.getHeaderName());
                    settings.setHeader(settingsDTO.getHeader());
                    settings.setFooter(settingsDTO.getFooter());
                    settingsRepository.save(settings);
                    return new ApiResponse(Status.Status_Ok, CustomConstants.Setting_SettingPost, settings);

                }


            }
            return new ApiResponse(Status.Status_ERROR, CustomConstants.Setting_IMAGEERROR, null);
        }

        public Boolean saveSettingslogo (MultipartFile file, String header, String unique){
            try {

                String UPLOADED_FOLDER_NEW = "C://TuckshopBackend_Main/TucShopBackend//serverFiles//" + header + "//";

                File dir = new File(UPLOADED_FOLDER_NEW);
                dir.setExecutable(true);
                dir.setReadable(true);
                dir.setWritable(true);

                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //  file.getsl
                BufferedImage inputImage = ImageIO.read(file.getInputStream());

                BufferedImage resized = resize(inputImage, 30, 30);
//            BufferedImage outputImage = new BufferedImage(100,
//                    100, inputImage.getType());

                String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                ImageIO.write(resized, format, new File(UPLOADED_FOLDER_NEW + unique + file.getOriginalFilename()));
//            byte[] bytes = outputImage.get//file.getBytes();
//            Path path = Paths.get(UPLOADED_FOLDER_NEW + unique+ file.getOriginalFilename());
//            Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        }

        private BufferedImage resize (BufferedImage img,int height, int width){
            Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = resized.createGraphics();
            g2d.drawImage(tmp, 0, 0, null);
            g2d.dispose();
            return resized;
        }


        public ResponseEntity<InputStreamResource> getSettingLogo (String filename, String header) throws IOException {


            String filepath = "C://TuckshopBackend_Main/TucShopBackend//serverFiles//" + header + "//" + filename;

            File f = new File(filepath);
            Resource file = new UrlResource(f.toURI());
            return ResponseEntity
                    .ok()
                    .contentLength(file.contentLength())
                    .contentType(
                            MediaType.parseMediaType("image/JPG"))
                    .body(new InputStreamResource(file.getInputStream()));
        }

        public List<Settings> getAll () {
            List<Settings> settingsList = settingsRepository.findAll();
            return settingsList;
        }


    public List<Products> getSearchedProducts(String s) {
    return  productsRepository.findByChar(s);
    }
}

