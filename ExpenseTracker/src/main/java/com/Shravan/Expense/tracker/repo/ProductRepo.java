package com.Shravan.Expense.tracker.repo;

import com.Shravan.Expense.tracker.Model.Product;
import com.Shravan.Expense.tracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    //List<Product> findAllByUserAndDate(LocalDate date, LocalTime time);
//
//    List<Product> findAllByUserAndDateBetween(LocalDate startDate, LocalDate endDate);





}
