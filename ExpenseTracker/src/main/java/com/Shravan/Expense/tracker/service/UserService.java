package com.Shravan.Expense.tracker.service;

import com.Shravan.Expense.tracker.Model.User;
import com.Shravan.Expense.tracker.Model.UserAuthenticationToken;
import com.Shravan.Expense.tracker.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PTokenService pTokenService;

    public String UserSingUp(User newUser) {
        String newUserName= newUser.getUsername();
        User existingUser=userRepo.findByUsername(newUserName);
        if(existingUser!=null){
            return "Already Exist User";
        }
        //passwords are encrypted before we store it in the table
        String newPassword=newUser.getPassword();
        try {

            String encryptedPassword=PasswordEncryptor.encrypt(newPassword);
            newUser.setPassword(encryptedPassword);
            // patient table - save patient
            userRepo.save(newUser);
            return "SingUP user ";
        }
        catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later!!!";
        }


    }

    public String SingIn(String username, String password) {
        User existingUser=userRepo.findByUsername(username);
        if(existingUser==null){
            return "Not a valid UserName, Please sign up first !!!";
        }
        //password should be matched
        try{
            String encryptedPassword=PasswordEncryptor.encrypt(password);
        if(existingUser.getPassword().equals(encryptedPassword)){
            // return a token for this sign in
            UserAuthenticationToken token =new UserAuthenticationToken(existingUser);
            pTokenService.CreateToken(token);
            return token.getToken();
        }
        else{
            return "Invalid Credentials!!!";
        }
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issues while saving password, try again later!!!";
        }

    }

    public User findByUsername(String username) {
     return userRepo.findByUsername(username);

    }
}
