package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.AuthToken;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.Config.JwtTokenUtil;
import com.example.TucShopBackend.Config.LocalDateEncryptDecryptConverter;
import com.example.TucShopBackend.DTO.LoginUser;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Repositories.UserDao;
import com.example.TucShopBackend.Services.UserServiceImpl;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @Autowired
    UserDao userDaoRepo;

    @Autowired
    LocalDateEncryptDecryptConverter localDateEncryptDecryptConverter;


    @GetMapping("/hello")
    public String test(){
        return "hello";
    }

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ApiResponse<AuthToken> register(@RequestBody LoginUser loginUser) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        LocalDate accessDate = LocalDate.now();
        if(user.getAccountAccessKey().equalsIgnoreCase("trial")){
            if (accessDate.isBefore(user.getAccountAccessDate()) || accessDate.isAfter(user.getAccountExpire())) {
                if (accessDate.isAfter(user.getAccountExpire())) {

                    final User userr = userService.findOne(loginUser.getUsername());
                    userr.setActive(false);
                    userDaoRepo.save(user);
                    return new ApiResponse<>(200, "Trial Version has Expired", null);
                }
                return new ApiResponse<>(200, "Trial Version has Expired", null);
            }else if(!user.getActive()){
                return  new ApiResponse<>(404,"User Expired Buy subscription",null);
            }
            LocalDateTime loginTime = LocalDateTime.now();
            String date = loginTime.toLocalDate().toString();
            String time = loginTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            if (user.getDate() == null && user.getTime() == null) {
                user.setTime(time);
                user.setDate(date);
                userDaoRepo.save(user);
                return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(),user.getAccountAccessKey(),user.getActive()));
            } else {
                if (user.getDate().equals(date)) {
                    return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(), user.getAccountAccessKey(), user.getActive() ));
                } else if (user.getDate() != date && user.getTime() != time) {
                    user.setTime(time);
                    user.setDate(date);
                    userDaoRepo.save(user);
                    return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(),user.getAccountAccessKey(), user.getActive()));
                }
            }

        } else {
            if (accessDate.isBefore(user.getAccountAccessDate()) || accessDate.isAfter(user.getAccountExpire())) {

                if (accessDate.isAfter(user.getAccountExpire()) ) {

                    final User userr = userService.findOne(loginUser.getUsername());
                    userr.setActive(false);
                    userDaoRepo.save(user);
                    return new ApiResponse<>(200, "Trial Version has Expired", null);
                }
                return new ApiResponse<>(200, "Trial Version has Expired", null);
            }

            LocalDateTime loginTime = LocalDateTime.now();
            String date = loginTime.toLocalDate().toString();
            String time = loginTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            if (user.getDate() == null && user.getTime() == null) {
                user.setTime(time);
                user.setDate(date);
                userDaoRepo.save(user);
                return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(), user.getAccountAccessKey(), user.getActive()));
            } else {
                if (user.getDate().equals(date)) {
                    return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(),user.getAccountAccessKey(),user.getActive()));
                } else if (user.getDate() != date && user.getTime() != time) {
                    user.setTime(time);
                    user.setDate(date);
                    userDaoRepo.save(user);
                    return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(),user.getAccountAccessKey(), user.getActive()));
                }
            }
        }
        return new ApiResponse<>(200, "success", new AuthToken(token, user.getName(), user.getUserType(), user.getEmail(),user.getAccountAccessKey(), user.getActive()));
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
