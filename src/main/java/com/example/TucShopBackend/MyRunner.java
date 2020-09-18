package com.example.TucShopBackend;


import com.example.TucShopBackend.Models.Category;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.CategoryRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

//    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private UserDao userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {
  userRepository.save(new User("t@t.com ", "test", bcryptEncoder.encode("111"),true, "USER", 1L, "trial"));
//        categoryRepository.save(new Category("Chips",null,null));

    }
}
