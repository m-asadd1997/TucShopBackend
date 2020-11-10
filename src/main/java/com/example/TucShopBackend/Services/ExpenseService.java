package com.example.TucShopBackend.Services;

import com.example.TucShopBackend.Commons.ApiResponse;
import com.example.TucShopBackend.Commons.Status;
import com.example.TucShopBackend.DTO.ExpenseDTO;
import com.example.TucShopBackend.DTO.ExpenseDetailsDTO;
import com.example.TucShopBackend.Models.Expense;
import com.example.TucShopBackend.Models.Expense_Details;
import com.example.TucShopBackend.Repositories.ExpenseDetailsRepository;
import com.example.TucShopBackend.Repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    ExpenseDetailsRepository expenseDetailsRepository;

    public ApiResponse postExpense(ExpenseDTO expenseDTO){

        Expense expense = new Expense();
        expense.setTotal(expenseDTO.getTotal());
        expense.setDate(expenseDTO.getDate());

        List<Expense_Details> expenseDetailsList = new ArrayList<Expense_Details>();

       for(ExpenseDetailsDTO expenseDetailsDTO :expenseDTO.getExpenseDetails()) {

           Expense_Details expense_details = new Expense_Details();
           expense_details.setAmount(expenseDetailsDTO.getAmount());
           expense_details.setBalance(expenseDetailsDTO.getBalance());
           expense_details.setCredit(expenseDetailsDTO.getCredit());
           expense_details.setDebit(expenseDetailsDTO.getDebit());
           expense_details.setSubject(expenseDetailsDTO.getSubject());
           expense_details.setType(expenseDetailsDTO.getType());
           expense_details.setExpense(expense);
           expenseDetailsList.add(expense_details);
       }
        expense.setExpenseDetailsList(expenseDetailsList);
        expenseRepository.save(expense);
        return new ApiResponse(Status.Status_Ok,"Successfully Saved",null);
    }

    public ApiResponse getExpenseByDate(String date){

        Expense expense = expenseRepository.getExpenseByDate(date);
        if(expense!=null){
            return new ApiResponse(Status.Status_Ok,"Successfully Get",expense);
        }
        return new ApiResponse(Status.Status_ERROR,"Not Found",null);
    }

    public ApiResponse updateExpense(Long id, ExpenseDTO expenseDTO){

        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if(expenseOptional!=null) {

            Expense expense1 = expenseOptional.get();
            expense1.setTotal(expenseDTO.getTotal());
            expense1.setDate(expenseDTO.getDate());

            List<Expense_Details> listForUpdate = new ArrayList<>();
            List<Expense_Details> expenseDetailsList1 = expenseDetailsRepository.getExpenseDetailsByForeignKey(id);
            int length = expenseDetailsList1.size();
            listForUpdate.clear();
            if (expenseDTO.getExpenseDetails().size() < expenseDetailsList1.size())
            {
                for(int i = 0;i<expenseDTO.getExpenseDetails().size();i++){
                    Expense_Details expense_details = new Expense_Details();
                    expense_details.setId(expenseDetailsList1.get(i).getId());
                    expense_details.setAmount(expenseDTO.getExpenseDetails().get(i).getAmount());
                    expense_details.setDebit(expenseDTO.getExpenseDetails().get(i).getDebit());
                    expense_details.setBalance(expenseDTO.getExpenseDetails().get(i).getBalance());
                    expense_details.setCredit(expenseDTO.getExpenseDetails().get(i).getCredit());
                    expense_details.setSubject(expenseDTO.getExpenseDetails().get(i).getSubject());
                    expense_details.setType(expenseDTO.getExpenseDetails().get(i).getType());
                    expense_details.setExpense(expense1);
                    listForUpdate.add(expense_details);
                }
                length=expenseDTO.getExpenseDetails().size();
                for (int i = length; i < expenseDetailsList1.size(); i++) {

                    expenseDetailsRepository.delete(expenseDetailsList1.get(i));
                }
                expense1.setExpenseDetailsList(listForUpdate);
                expenseRepository.save(expense1);
                return new ApiResponse(Status.Status_Ok, "Successfully Updated", expense1);

            }
            else {
                for (int i = 0; i < expenseDetailsList1.size(); i++) {
                    Expense_Details expense_details = new Expense_Details();
                    expense_details.setId(expenseDetailsList1.get(i).getId());
                    expense_details.setAmount(expenseDTO.getExpenseDetails().get(i).getAmount());
                    expense_details.setDebit(expenseDTO.getExpenseDetails().get(i).getDebit());
                    expense_details.setBalance(expenseDTO.getExpenseDetails().get(i).getBalance());
                    expense_details.setCredit(expenseDTO.getExpenseDetails().get(i).getCredit());
                    expense_details.setSubject(expenseDTO.getExpenseDetails().get(i).getSubject());
                    expense_details.setType(expenseDTO.getExpenseDetails().get(i).getType());
                    expense_details.setExpense(expense1);
                    listForUpdate.add(expense_details);
                }
                for (int i = length; i < expenseDTO.getExpenseDetails().size(); i++) {
                    Expense_Details expense_details = new Expense_Details();
                    expense_details.setAmount(expenseDTO.getExpenseDetails().get(i).getAmount());
                    expense_details.setDebit(expenseDTO.getExpenseDetails().get(i).getDebit());
                    expense_details.setBalance(expenseDTO.getExpenseDetails().get(i).getBalance());
                    expense_details.setCredit(expenseDTO.getExpenseDetails().get(i).getCredit());
                    expense_details.setSubject(expenseDTO.getExpenseDetails().get(i).getSubject());
                    expense_details.setType(expenseDTO.getExpenseDetails().get(i).getType());
                    expense_details.setExpense(expense1);
                    listForUpdate.add(expense_details);
                }
                expense1.setExpenseDetailsList(listForUpdate);
                expenseRepository.save(expense1);
                return new ApiResponse(Status.Status_Ok, "Successfully Updated", expense1);
            }

        }
        return  new ApiResponse(Status.Status_ERROR,"Error",null);
    }
}