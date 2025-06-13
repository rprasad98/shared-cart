package com.example.demo.Entity;


import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items")
public class CartItems {

    @Id
    private Integer id;

    @Column(name="quantity")
    private Integer quantity;

    @CreatedDate
    @Column(name="created_at")
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name="cart_name",referencedColumnName = "cart_name" ,nullable = false)
    private Cart cartName;

    @ManyToOne
    @JoinColumn(name="user_name",referencedColumnName = "user_name",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn (name="item_name",referencedColumnName = "item_name",nullable = false)
    private Item item;

}
