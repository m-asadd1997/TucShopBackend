package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    User findByEmail(String username);

    @Query(value = "select * from tucshop.user u where u.active= 1",nativeQuery = true)
    List<User> getAllUsers();



}
