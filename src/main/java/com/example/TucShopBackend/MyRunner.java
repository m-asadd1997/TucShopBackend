package com.example.TucShopBackend;


import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.TokenRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MyRunner implements CommandLineRunner {

//    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserDao userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {

//        userRepository.save(new User("b@b.com", "Admin", bcryptEncoder.encode("111"),true, "ADMIN", 1L, "TRAIL"));


//        Uncomment below lines if you want to create User and Admin By My runner.
        
        
//        LocalDate accessDate = LocalDate.now();
//        LocalDate expireDate = LocalDate.now().plusMonths(1);
//
//        userRepository.save(new User("t@t.com ", "usertest", bcryptEncoder.encode("111"),true, "USER", 1l, accessDate, expireDate,"trial"));
//        userRepository.save(new User("a@a.com ", "admintest", bcryptEncoder.encode("111"),true, "ADMIN", 1l, accessDate, expireDate,"trial"));

   
        
        
//        categoryRepository.save(new Category("Chips",null,null));

    }
}
