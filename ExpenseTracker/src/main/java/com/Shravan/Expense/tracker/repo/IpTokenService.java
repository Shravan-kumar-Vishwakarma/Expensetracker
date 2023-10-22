package com.Shravan.Expense.tracker.repo;

import com.Shravan.Expense.tracker.Model.UserAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpTokenService extends JpaRepository<UserAuthenticationToken,Integer> {

}
