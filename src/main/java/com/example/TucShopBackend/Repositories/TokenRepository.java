package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository <Token, Long> {

   // public Token findSubscriptionToken(String token);


}
