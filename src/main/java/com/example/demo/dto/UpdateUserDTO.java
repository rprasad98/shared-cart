package com.example.demo.dto;

import com.example.demo.Enum.UserType;
import lombok.Data;

@Data
public class UpdateUserDTO {

    private String fullName;
    private UserType type;



}
