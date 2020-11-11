package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query(value = "Select * from expense where date=:date",nativeQuery = true)
    public Expense getExpenseByDate(@Param("date") String date);

    @Query(value = "SELECT * FROM expense e WHERE  e.date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Expense> downloadExpenseByDate(@Param("startDate") String startDate, @Param("endDate") String endDate);

    @Query(value = "SELECT * FROM expense e WHERE  e.date=:startDate", nativeQuery = true)
    Expense expenseByDate(@Param("startDate") String startDate);
}