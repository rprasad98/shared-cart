package com.example.demo.Entity;


import com.example.demo.Enum.UserType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.Enum.UserType.ADMIN;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "idx_user_user_name", columnList = "user_name")
})
public class User {

    @Id
    @Column(name="user_name")
    private String userName;

    @Column(name="full_name")
    private String fullName;


    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private UserType type =ADMIN;

    @OneToMany(mappedBy = "adminUser")
    private List<Cart> cartList;

}
