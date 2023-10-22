package com.Shravan.Expense.tracker.Controller;

import com.Shravan.Expense.tracker.Model.Product;
import com.Shravan.Expense.tracker.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("post/Data")
    public String postDataProducts(@RequestBody Product newproduct, @RequestParam String username){
        return productService.postDataProducts(newproduct,username);
    }
    @GetMapping("gets")
    public List<Product> GetAll(@RequestParam String username){
        return productService.GetAll(username);
    }
    @PutMapping("/user/{username}/product/{id}")
    public String Update(@PathVariable String username,@PathVariable Long id,@RequestParam double price){
        return productService.update(username,id,price);
    }
    @DeleteMapping("/user/{username}/{id}")
    public String Deleting(@PathVariable String username,@RequestParam Long id){
        return productService.Deleting(username,id);
    }
//    @GetMapping("/by-date")
//    public List<Product> getExpensesByDate(
//            @RequestParam String username,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
//            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time
//    ) {
//        List<Product> expenses = productService.getExpensesByDate(username, date, time);
//
//                return  productService.getExpensesByDate(username, date, time);
//    }

}
