package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.CustomConstants;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.*;
import com.example.TucShopBackend.Models.*;
import com.example.TucShopBackend.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.imageio.ImageIO;
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

    public ApiResponse productQuantityDetails(String startDate,String endDate) {
        return new ApiResponse(Status.Status_Ok, "Total products Details", productsRepository.productQauntityDetails(startDate,endDate));
    }

    public ApiResponse outOfStockProductsDetails() {
        return new ApiResponse(Status.Status_Ok, "Out of Stock Product", productsRepository.outOfStockProducts());
    }

    public ApiResponse outOfStockProducts() {
        return new ApiResponse(Status.Status_Ok, "Out of Stock", productsRepository.outOfStockCount());
    }

    public ApiResponse totalTransaction() {
        return new ApiResponse(Status.Status_Ok, "Successfully fetch Total Transaction", transactionsRepository.getTotalTransaction());
    }

    public ApiResponse transactionDetails() {
        return new ApiResponse(Status.Status_Ok, "Get Transaction Details", transactionsRepository.getTransactionDetails());
    }


    public ApiResponse requestedProductsKeyword(String keyword) {
        List<RequestForProduct> topRequestedProductsKeyword = requestForProductRepository.topRequestedProductsKeyword(keyword);
        return new ApiResponse(Status.Status_Ok, "Successfully keyword Match From requested Product", topRequestedProductsKeyword);
    }

    public ApiResponse requestedProductsCount() {
        List<RequestForProduct> topRequestedProductsCount = requestForProductRepository.topRequestedProductsCount();

        return new ApiResponse(Status.Status_Ok, "Successfully get top requested Product Count", topRequestedProductsCount);
    }
//    public ApiResponse profit() {
//
//    }

    public ApiResponse getProfit(String startDate, String endDate){

        List<ProfitDTO> getProfit;
        try{
           getProfit = productsRepository.getProfit(startDate, endDate);
        }catch(Exception e){
            return new ApiResponse(Status.Status_Ok, "Get Profit By Months", null);
        }

        return new ApiResponse(Status.Status_Ok, "Get Profit By Months", getProfit);

        }

    public ApiResponse getCategoryFrequency() {
        List<CategoryQuantityDTO> categoryQuantityDTOList= transactionsRepository.getFrequency();
        return new ApiResponse(Status.Status_Ok, "Success", categoryQuantityDTOList);
    }

    public ApiResponse getFilteredCategoryFrequency(String startDate, String endDate) {

        List<CategoryQuantityDTO> categoryQuantityDTOFilteredList;
        try {
           categoryQuantityDTOFilteredList = transactionsRepository.getFilteredFrequency(startDate,endDate);
        }
        catch (Exception e) {
            return new ApiResponse(Status.Status_Ok,"Null",null);
        }
        return new ApiResponse(Status.Status_Ok, "Success", categoryQuantityDTOFilteredList);
    }

    public ApiResponse getTransactionMethod(){
        List<CategoryQuantityDTO> transactionMethodList = transactionsRepository.getTransactionMethod();
        return new ApiResponse(Status.Status_Ok, "Success", transactionMethodList);
    }

    public ApiResponse getFilteredTransactionMethod(String startDate, String endDate){

        List<CategoryQuantityDTO> filteredTransactionMethodList;
        try {
            filteredTransactionMethodList = transactionsRepository.getFilteredTransactionMethod(startDate,endDate);
        }
        catch (Exception e){
            return new ApiResponse(Status.Status_Ok,"Null",null);
        }
        return new ApiResponse(Status.Status_Ok,"Success",filteredTransactionMethodList);
    }


    public ApiResponse getMonthlySales() {
        List<LocalDate> dates = new ArrayList<>();
        List<Double> seperateAmounts= new ArrayList<>();
        String monthName = "";
        Map<String, Double> map = new HashMap<>();
        List<Transactions> transactionsList = transactionsRepository.findAll();
        for (Transactions transaction : transactionsList) {
            if(transaction.getStatus().equals("complete"))
            {
            monthName = transaction.getDate().getMonth().toString();
            if (!map.containsKey(monthName)) {
                map.put(monthName, transaction.getAmount());
            }
            else {
                map.put(monthName, map.get(monthName).doubleValue() + transaction.getAmount());
            }
            dates.add(transaction.getDate());
            seperateAmounts.add(transaction.getAmount());}

        }

        System.out.println(map);
        ChartDataDTO cdt = new ChartDataDTO();
        List<String> labelList = new ArrayList<>();
        List<Double> seriesList = new ArrayList<>();
        for (Map.Entry<String, Double> entry : map.entrySet()) {

            labelList.add(entry.getKey());
            seriesList.add(entry.getValue());
        }

        if (labelList != null && seriesList != null && dates!=null) {
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
            String folderPath = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+"settings";
            File folder = new File(folderPath);
            settingsRepository.deleteAll();
            deleteDirectory(folder);
            String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            saveSettingslogo (settingsDTO.getLogo(),unique);
            Settings settings = new Settings();
            if(settingsDTO.getLogo()!=null) {
                settings.setLogo(settingLogoUrl + unique + settingsDTO.getLogo().getOriginalFilename());
            }
            settings.setHeader(settingsDTO.getHeader());
            settings.setFooter(settingsDTO.getFooter());
            settingsRepository.save(settings);
            return new ApiResponse(Status.Status_Ok, CustomConstants.SETTING_UPDATED, settings);

        }

            else {
                String folderPath = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+"settings";
                File folder = new File(folderPath);
                settingsRepository.deleteAll();
                deleteDirectory(folder);

                String unique = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
            if(settingsDTO.getLogo()==null){
                Settings settings = new Settings();
                settings.setHeader(settingsDTO.getHeader());
                settings.setFooter(settingsDTO.getFooter());
                settingsRepository.save(settings);
                return new ApiResponse(Status.Status_Ok, CustomConstants.SETTING_POSTED, null);
            }
               else if (saveSettingslogo(settingsDTO.getLogo(), unique)) {
                    Settings settings = new Settings();
                    if(settingsDTO.getLogo()!=null)
                    settings.setLogo(settingLogoUrl + unique + settingsDTO.getLogo().getOriginalFilename());
                    settings.setHeader(settingsDTO.getHeader());
                    settings.setFooter(settingsDTO.getFooter());
                    settingsRepository.save(settings);
                    return new ApiResponse(Status.Status_Ok, CustomConstants.SETTING_POSTED, settings);

                }
//                else if(settingsDTO.getLogo()==null){
//                    Settings settings = new Settings();
//                    settings.setHeader(settingsDTO.getHeader());
//                    settings.setFooter(settingsDTO.getFooter());
//                    settingsRepository.save(settings);
//                    return new ApiResponse(Status.Status_Ok, CustomConstants.SETTING_POSTED, settings);
//                }
            }
            return new ApiResponse(Status.Status_ERROR, CustomConstants.SETTINGIMAGE_ERROR, null);
        }

        public Boolean saveSettingslogo (MultipartFile file, String unique){
            try {

                String UPLOADED_FOLDER_NEW = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+"settings"+"//";
                File dir = new File(UPLOADED_FOLDER_NEW);
                dir.setExecutable(true);
                dir.setReadable(true);
                dir.setWritable(true);

                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //  file.getsl
                BufferedImage inputImage = ImageIO.read(file.getInputStream());

                BufferedImage resized = resize(inputImage, 100, 100);
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


        public ResponseEntity<InputStreamResource> getSettingLogo (String filename) throws IOException {


            String filepath = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+"settings"+"//"+filename;

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



    public List<Product> getSearchedProducts(String s) {
    return  productsRepository.findByChar(s);


    }

    private boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }


    public ApiResponse filteredQuantity(String startDate,String endDate) {
        return new ApiResponse(Status.Status_Ok,"Succesfully Fetched",productsRepository.filteredQuantity(startDate,endDate));
    }

    public ApiResponse outOfStockFilteredProducts(String startDate,String endDate) {
        return  new ApiResponse(Status.Status_Ok,"Succesfully Fetched",productsRepository.outOfStockFiltered(startDate,endDate));
    }

    public ApiResponse filteredTransaction(String startDate, String endDate) {
        Double transaction=transactionsRepository.filteredTransaction(startDate,endDate);
        if(transaction==null){
            transaction=0.0;
        }
        return  new ApiResponse(Status.Status_Ok,"Succesfully Fetched",transaction);
    }

    public ApiResponse detailedFilteredTransaction(String startDate, String endDate) {
        return new ApiResponse(Status.Status_Ok, "Succesfully Fetched", transactionsRepository.getFilteredDetailedTransaction(startDate, endDate));
    }

    public ApiResponse getTotalProfit(){
        List<Object> getTotalProfit ;
        try {
            getTotalProfit =productsRepository.getTotalprofit();

        } catch(Exception e){
            return new ApiResponse(Status.Status_Ok, "Get Total Profit", null);
        }

        return new ApiResponse(Status.Status_Ok, "Get Total Profit",getTotalProfit );


    }

    public ApiResponse getTotalInventory(){
        Long getTotalInventory;
        try{
            getTotalInventory = productsRepository.getTotalInventory();
        }
        catch (Exception e){
            return new ApiResponse(Status.Status_Ok,"Null",null);
        }
        return new ApiResponse(Status.Status_Ok,"Success",getTotalInventory);
    }

    public ApiResponse getFilteredTotalInventory( String startDate, String endDate){
         Long getFilteredTotalInventory;
         try{
             getFilteredTotalInventory =productsRepository.getFilteredTotalInventory(startDate,endDate);
         }
         catch (Exception e){
             return  new ApiResponse(Status.Status_Ok,"Null",null);
         }

        return new ApiResponse(Status.Status_Ok,"Success",getFilteredTotalInventory);
    }
}

