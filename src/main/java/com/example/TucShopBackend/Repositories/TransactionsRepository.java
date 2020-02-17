package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

    @Query(value = "select sum(amount) from transactions", nativeQuery = true)
    public double getTotalTransaction();

    @Query(value = "select * from transactions", nativeQuery = true)
    public List<Transactions> getTransactionDetails();
}
