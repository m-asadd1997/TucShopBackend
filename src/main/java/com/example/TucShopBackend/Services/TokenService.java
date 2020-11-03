package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.Config.AttributeEncryptor;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.TokenRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AttributeEncryptor attributeEncryptor;

    public ApiResponse validateSubscriptionToken (String token){
        String encryptedToken = attributeEncryptor.convertToDatabaseColumn(token);
       Token subscriptionToken = tokenRepository.findByToken(encryptedToken);
        if(subscriptionToken!=null){
           List <User> founduser = userDao.findAll();
           if(!founduser.isEmpty()) {
              for(User user : founduser){
                  user.setAccountExpire(user.getAccountExpire().plusMonths(1));
                  user.setActive(Boolean.TRUE);
              }
              userDao.saveAll(founduser);
              tokenRepository.deleteById(subscriptionToken.getId());
           }
        }else{
            return new ApiResponse(Status.Status_ERROR, "Invalid Subscription Token", token);

        }
        return new ApiResponse(Status.Status_Ok, "User Trial Extended", token);

    }
}
