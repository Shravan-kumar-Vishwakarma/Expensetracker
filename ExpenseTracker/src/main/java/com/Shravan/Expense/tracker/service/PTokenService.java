package com.Shravan.Expense.tracker.service;

import com.Shravan.Expense.tracker.Model.UserAuthenticationToken;
import com.Shravan.Expense.tracker.repo.IpTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PTokenService {
    @Autowired
    IpTokenService ipTokenService;

    public void CreateToken(UserAuthenticationToken token) {
    ipTokenService.save(token);
    }
}
