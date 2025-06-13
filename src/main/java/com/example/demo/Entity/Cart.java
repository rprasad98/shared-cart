package com.example.demo.Entity;


import jakarta.persistence.*;

import javax.lang.model.element.Name;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Cart")
public class Cart {

    @Id
    @Column(name="cart_name")
    private String cartName;

    @ManyToOne
    @JoinColumn(name="admin_user", referencedColumnName = "user_name",nullable = false)
    private User adminUser;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "cartName")
    private List<CartItems> cartItems;

}
