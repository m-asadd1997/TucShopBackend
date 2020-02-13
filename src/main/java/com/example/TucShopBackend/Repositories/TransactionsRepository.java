package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

    @Query(value = "select SUM(amount) from transactions ",nativeQuery = true)
    public double getTransactionsAmount();
}
