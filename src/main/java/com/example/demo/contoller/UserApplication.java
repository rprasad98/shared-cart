package com.example.demo.contoller;

import com.example.demo.Service.impl.UserServiceImpl;
import com.example.demo.dto.ErrorResponseDTO;
import com.example.demo.dto.UpdateUserDTO;
import com.example.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserApplication {

    @Autowired
    private UserServiceImpl userServiceImpl;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);


    @GetMapping("api/v1/user")
    public ResponseEntity<List<UserDTO>> getUser(@RequestParam(required=false,value="userName",defaultValue ="") String userName){
          return userServiceImpl.getUser(userName);
    }

    @PostMapping("api/v1/user")
    public ResponseEntity<?> AddUser(@RequestBody UserDTO user){
        ResponseEntity<?> response = userServiceImpl.addUser(user);
        log.info("API Response: {}", response);
        return response;

    }

    @PutMapping("api/v1/user/{userName}")
    public ResponseEntity<?> UpdateUser(@PathVariable String userName, @RequestBody UpdateUserDTO user){
        ResponseEntity<?> response = userServiceImpl.updateUser(userName,user);
        log.info("API Response: {}", response);
        return response;
    }

    @DeleteMapping("api/v1/user/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable String userName){
        ResponseEntity<?> response = userServiceImpl.deleteUser(userName);
        log.info("API Response: {}", response);
        return response;
    }
}
