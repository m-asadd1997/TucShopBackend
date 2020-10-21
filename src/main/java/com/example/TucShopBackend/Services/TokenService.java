package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.TokenDTO;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.TokenRepository;
import com.example.TucShopBackend.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    private UserDao userDao;



    public ApiResponse validateSubscriptionToken (String token, UserDto userDto){
       List <Token> allSubscriptionToken = tokenRepository.findByToken(token);
        User founduser = userDao.findByEmail(userDto.getEmail());
        if(allSubscriptionToken.equals(token)){
            founduser.setAccountAccessDate(LocalDate.now().plusMonths(1));
            founduser.setAccountExpire(LocalDate.now().plusYears(1));
        }
        return new ApiResponse(Status.Status_Ok, "User Trial Extended", token);
    }
}
