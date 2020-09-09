package com.example.TucShopBackend.Controllers;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.UserDto;
import com.example.TucShopBackend.Models.Product;
import com.example.TucShopBackend.Models.User;
import com.example.TucShopBackend.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/")
    public ApiResponse getUsers()
    {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getUserById(@PathVariable("id") Long id){

        return userService.getUserById(id);
    }


    @DeleteMapping("/{id}")
    public ApiResponse deleteUserById(@PathVariable("id") Long id){


        return userService.deleteUser(id);
    }

    @PutMapping ("/{id}")
    public ApiResponse updateUser(@PathVariable("id")Long id ,@RequestBody UserDto userDTO)
    {
         return userService.updateUser(id,userDTO);
    }

    @GetMapping ("/getUserTimeDate/{user}")
    public  ApiResponse getUserByLogin (@PathVariable("user") String user){
        return userService.getUserByLogin(user);
    }


}
