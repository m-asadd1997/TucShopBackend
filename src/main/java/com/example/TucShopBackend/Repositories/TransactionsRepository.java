package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.DTO.CategoryQuantityDTO;
import com.example.TucShopBackend.DTO.ChartDataDTO;
import com.example.TucShopBackend.Models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long> {

                   //id,created_by,updated_by,date

    @Query(value = "select *, sum(amount)amount from transactions t  WHERE t.date BETWEEN :date1 AND :date2 group by created_by AND  t.status='complete'", nativeQuery = true)
    public List<Transactions> getMonthTransactions(@Param("date1") String date1,@Param("date2") String date2);


    public List<Transactions> findBycreatedBy(String user);

    @Query(value = "SELECT * FROM transactions WHERE  date BETWEEN :date1 AND :date2 and created_by=:user AND  t.status='complete' ", nativeQuery = true)
    public List<Transactions> scearchTransactionsOfUser(@Param("date1") String date1,@Param("date2") String date2,@Param("user") String user);

    @Query(value = "select SUM(amount) from transactions t where t.status='complete'", nativeQuery = true)
    public Double getTotalTransaction();

    @Query(value = "select * from transactions t where t.status='complete' ", nativeQuery = true)
    public List<Transactions> getTransactionDetails();
//
//    @Query(value = "SELECT  MONTHNAME(date) as months, SUM(amount) as total_sales from transactions where date IS NOT NULL AND YEAR(date) GROUP BY MONTHNAME(date) ORDER BY month(date)",nativeQuery = true)
//    public List<Object> getMonthlySale();



    @Query(value = "select * from transactions t where t.status='complete' order by (id) DESC LIMIT 30 ", nativeQuery = true)
    public List<Transactions> recentTransactions();

    @Query(value="select SUM(amount) from transactions t where t.date BETWEEN cast(:startDate as date)AND cast(:endDate as date) AND  t.status='complete'",nativeQuery = true)
    Double filteredTransaction(String startDate, String endDate);


    @Query(value = "select * from transactions t where t.date BETWEEN cast(:startDate as date)AND cast(:endDate as date) AND  t.status='complete'",nativeQuery = true)
    List<Transactions> getFilteredDetailedTransaction(String startDate,String endDate);

    @Query(value="select new com.example.TucShopBackend.DTO.CategoryQuantityDTO (c.name,Sum(pt.quantity)) from ProductTransaction pt join Transactions t on pt.transaction.id=t.id join Product p on pt.product.id=p.id join Category c on p.category.id= c.id group by c.name")
    List<CategoryQuantityDTO> getFrequency();


    @Query(value = "Select * from transactions t where t.status = 'pending' ",nativeQuery = true)
    List<Transactions>getAllPending();

    @Query(value = "select new com.example.TucShopBackend.DTO.CategoryQuantityDTO (t.action , count(t.action) ) from Transactions t group by t.action ")
    List<CategoryQuantityDTO> getTransactionMethod();


}

