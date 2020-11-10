package com.example.TucShopBackend.Repositories;

import com.example.TucShopBackend.Models.Expense_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseDetailsRepository extends JpaRepository<Expense_Details,Long> {
    @Query(value = "select * from expense_details e where e.expense_id = :id ",nativeQuery = true)
    public List<Expense_Details> getExpenseDetailsByForeignKey(@Param("id") Long id);

}