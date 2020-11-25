package com.example.TucShopBackend.Controllers;
import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.DTO.CartDTO;
import com.example.TucShopBackend.Models.Cart;
import com.example.TucShopBackend.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/")
    public ApiResponse saveToCart(@RequestBody  CartDTO cartDTO){
        return cartService.saveCart(cartDTO);
    }

//    @PutMapping("/{id}")
//    public ApiResponse saveToCart(@PathVariable("id") Long id,@RequestBody Cart cartDTO){
//        return cartService.updateCart(id,cartDTO);
//    }
}
