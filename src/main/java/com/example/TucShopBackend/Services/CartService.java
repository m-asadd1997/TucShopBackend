package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.CartDTO;
import com.example.TucShopBackend.Models.Cart;
import com.example.TucShopBackend.Models.ProductCart;
import com.example.TucShopBackend.Repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;


    public ApiResponse saveCart(CartDTO cartDTO){
        Cart cart = new Cart();
        cart.setAmount(cartDTO.getAmount());
        Set<ProductCart> productCartSet = new HashSet<>();
        for (ProductCart productCart :cartDTO.getProductCartList()){
            productCartSet.add(new ProductCart(cart, productCart.getProduct(), productCart.getQuantity()));
        }
        cart.setProducts(productCartSet);
        cartRepository.save(cart);
       return new ApiResponse(Status.Status_Ok,"Saved to Cart",cart);
    }


//    public ApiResponse updateCart(Long id, Cart cart){

//        Set<ProductCart> productCarts = cartRepository.findAllProductCarts(id);
//        List<ProductCart> toBeDeleted = new ArrayList<>();
//        for(ProductCart productCart: productCarts){
//           toBeDeleted = cart.getProductCartSet().stream().filter(x->x.getProduct().getId() != productCart.getProduct().getId()).collect(Collectors.toList());
//        }
//
//        for(ProductCart productCart : toBeDeleted){
////            cartRepository.deleteChildRecordsWhichAreNotUpdated(productCart.getProduct().getId(),id);
//            System.out.println(productCart.getProduct().getId());
//        }
//
//        Cart cartOptional = cartRepository.findById(id).get();
//        cartOptional.setId(id);
//        cartOptional.setProductCartSet(cart.getProductCartSet());
//
//        return new ApiResponse(Status.Status_Ok,"cart updated",cartRepository.save(cartOptional));
//
//    }

}
