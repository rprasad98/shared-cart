package com.example.demo.dto;

import com.example.demo.Enum.UserType;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.processing.Pattern;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    @NotNull
    private String userName;

    @Size(max=100,message = "Full Name must not exceed 100 characters")
    private String fullName;

    private UserType type;


    private LocalDateTime createdAt;

}
