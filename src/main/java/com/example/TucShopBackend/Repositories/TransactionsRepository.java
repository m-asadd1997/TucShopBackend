package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.ChartDataDTO;
import com.example.TucShopBackend.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {



    @Query(value = "select id,created_by,updated_by,date,sum(amount)amount from transactions  WHERE date BETWEEN :date1 AND :date2 group by created_by", nativeQuery = true)
    public List<Transactions> getMonthTransactions(@Param("date1") String date1,@Param("date2") String date2);


    public List<Transactions> findBycreatedBy(String user);

    @Query(value = "SELECT * FROM transactions WHERE  date BETWEEN :date1 AND :date2 and created_by=:user ", nativeQuery = true)
    public List<Transactions> scearchTransactionsOfUser(@Param("date1") String date1,@Param("date2") String date2,@Param("user") String user);

    @Query(value = "select amount,date from transactions", nativeQuery = true)
    public List<Object> getTotalTransaction();

    @Query(value = "select * from transactions", nativeQuery = true)
    public List<Transactions> getTransactionDetails();
//
//    @Query(value = "SELECT  MONTHNAME(date) as months, SUM(amount) as total_sales from transactions where date IS NOT NULL AND YEAR(date) GROUP BY MONTHNAME(date) ORDER BY month(date)",nativeQuery = true)
//    public List<Object> getMonthlySale();



    @Query(value = "select * from transactions order by (id) DESC LIMIT 30 ", nativeQuery = true)
    public List<Transactions> recentTransactions();
}

