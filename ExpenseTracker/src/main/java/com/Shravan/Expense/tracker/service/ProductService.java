package com.Shravan.Expense.tracker.service;

import com.Shravan.Expense.tracker.Model.Product;
import com.Shravan.Expense.tracker.Model.User;
import com.Shravan.Expense.tracker.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.LocalTime;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserService userService;

    public String postDataProducts(Product newproduct, String username) {
        User user=userService.findByUsername(username);
            if(user!=null){
                productRepo.save(newproduct);
                return "Created Products";
            }
            else
                return "not created products";
    }


    public List<Product> GetAll(String username) {
        User user=userService.findByUsername(username);
        if(user!=null){
            return productRepo.findAll();
        }

        return null;

    }

    public String update(String username, Long id, double price) {
        User user=userService.findByUsername(username);

        if(user!=null){
            Optional<Product> product=productRepo.findById(id);
            if(product.isPresent()){
                Product product1=product.get();
                product1.setPrice(price);
                productRepo.save(product1);
                return "Product price updated successfully.";
            }
            else{
                return "Product not found.";
            }

        }
        else{
            return "User not found.";
        }
    }

    public String Deleting(String username, Long id) {
        User user=userService.findByUsername(username);
        if(user!=null){
            productRepo.deleteById(id);
            return "Delete ID";
        }
      return "Not Match ID";
    }

//    public List<Product> getExpensesByDate(String username, LocalDate date, LocalTime time) {
//        User user=userService.findByUsername(username);
//        if(user!=null){
//            if(time!=null){
//                LocalDate localDate=LocalDate.now();
//                return productRepo.findAllByUserAndDate(date,time);
//            }
//            else{
//                LocalDate startDate= LocalDate.from(date.atStartOfDay());
//                LocalDate endDate= LocalDate.from(date.atStartOfDay());
//                return productRepo.findAllByUserAndDateBetween(startDate,endDate);
//            }
//        }
//        return Collections.emptyList();
//    }

}
