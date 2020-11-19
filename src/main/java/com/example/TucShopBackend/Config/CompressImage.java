package com.example.TucShopBackend.Config;


import com.example.TucShopBackend.Commons.CustomConstants;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

@Service
public class CompressImage{

    public Boolean saveCompressImage(byte[] bytes, String name, String unique, String filename) throws IOException{

        String UPLOADED_FOLDER_NEW = CustomConstants.SERVER_PATH+"//"+"serverFiles//"+name+"//"+"products"+"//";

        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);

            File compressedImageFile = new File(UPLOADED_FOLDER_NEW+unique+filename);
            OutputStream outputStream = new FileOutputStream(compressedImageFile);

            float imageQuality = 0.3f;

            //Create the buffered image
            BufferedImage bufferedImage = ImageIO.read(inputStream);

            //Get image writers
            Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByFormatName("jpg");

            if (!imageWriters.hasNext())
                throw new IllegalStateException("Writers Not Found!!");

            ImageWriter imageWriter = (ImageWriter) imageWriters.next();
            ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
            imageWriter.setOutput(imageOutputStream);

            ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();

            //Set the compress quality metrics
            imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            imageWriteParam.setCompressionQuality(imageQuality);

            //Created image
            imageWriter.write(null, new IIOImage(bufferedImage, null, null), imageWriteParam);

            // close all streams
            inputStream.close();
            outputStream.close();
            imageOutputStream.close();
            imageWriter.dispose();

        }
        catch (IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}