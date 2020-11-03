package com.example.TucShopBackend.Repositories;
import com.example.TucShopBackend.Models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Convert;
import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository <Token, Long> {

      @Query(value="select * from token where token=:token", nativeQuery = true)
      Token findByToken (@Param("token") String token);
}
