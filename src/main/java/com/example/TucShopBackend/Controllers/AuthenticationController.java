package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.AuthToken;
import com.example.TucShopBackend.Config.JwtTokenUtil;
import com.example.TucShopBackend.DTO.LoginUser;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/hello")
    public String test(){
        return "hello";
    }
    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);

        return new ApiResponse<>(200, "success",new AuthToken(token,user.getName(),user.getUserType(),user.getEmail()));
    }


    @PostMapping("/user")
    public ApiResponse<User> saveUser(@RequestBody UserDto user){

        return new ApiResponse<>(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return this.userService.findAll();
    }
}
