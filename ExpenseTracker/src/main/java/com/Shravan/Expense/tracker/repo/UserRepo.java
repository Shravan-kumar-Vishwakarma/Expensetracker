package com.Shravan.Expense.tracker.repo;

import com.Shravan.Expense.tracker.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String newUserName);
}
