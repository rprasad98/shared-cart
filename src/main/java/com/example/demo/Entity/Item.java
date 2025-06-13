package com.example.demo.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name="Items")

public class Item {

    @Id
    @Column(name="item_name")
    private String itemName;

    @Column(name="full_name")
    private String fullName;

    @Column(name="created_at")
    @CreatedDate
    private LocalDateTime localDateTime;

    @Column(name="category")
    private String category;

}
