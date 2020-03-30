package com.example.TucShopBackend;
import com.example.TucShopBackend.Commons.CustomConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TucShopBackendApplication {
    public static void main(String[] args) { SpringApplication.run(TucShopBackendApplication.class, args);
        final String dir = System.getProperty("user.dir");
		System.out.println("current dir = " + dir);

        CustomConstants.SERVER_PATH = dir;
	}
}

