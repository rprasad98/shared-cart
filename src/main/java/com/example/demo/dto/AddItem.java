package com.example.demo.dto;


import lombok.Data;

@Data
public class AddItem {

    private String userId;
    private String itemId;
    private Integer quantity;

}
