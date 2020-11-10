package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    @Query(value = "Select * from tucshop.expense where date=:date",nativeQuery = true)
    public Expense getExpenseByDate(@Param("date") String date);
}