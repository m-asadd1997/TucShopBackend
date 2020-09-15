package com.example.TucShopBackend;

import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

//    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserDao repository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new User("a@a.com","Admin",bcryptEncoder.encode("122"),true,"ADMIN",1L));
//        String ip = InetAddress.getLocalHost().getHostAddress();
//        Constants.galleryImagePath = "https://"+ip+":8447/api/gallery/";

    }
}
