package com.example.TucShopBackend.Controllers;


import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.TokenDTO;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.Token;
import com.example.TucShopBackend.Services.TokenService;
import com.example.TucShopBackend.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping ("/api/subscription")
public class SubscriptionTokenController {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/{token}")
    public ApiResponse subscriptionToken (@PathVariable ("token") String token,  @RequestBody UserDto userDto ){
        return tokenService.validateSubscriptionToken(token, userDto )  ;
    }

}
