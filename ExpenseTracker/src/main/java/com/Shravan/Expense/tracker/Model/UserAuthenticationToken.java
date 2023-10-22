package com.Shravan.Expense.tracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "UAuthentication")
public class UserAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // private String userValue;
    private String token;
    private LocalDate tokenCreationDate;
    @OneToOne
    @JoinColumn(name = "user_id")
    private  User user;
    //each token should be linked with a patient

    public UserAuthenticationToken(User user) {
        this.token= token;
        this.user=user;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }

}
