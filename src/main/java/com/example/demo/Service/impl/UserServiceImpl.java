package com.example.demo.Service.impl;


import com.example.demo.Entity.User;
import com.example.demo.Enum.UserType;
import com.example.demo.Exception.UserAlreadyExistException;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.UpdateUserDTO;
import com.example.demo.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.Enum.UserType.ADMIN;



@Service
public class UserServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;



    public ResponseEntity<List<UserDTO>> getUser(String userName){
        if(userName==null || userName.isEmpty()) {
            List<User> users = userRepository.findAll();
            List<UserDTO> usersDTO = users.stream().map(this::convertToDTO).toList();
            return ResponseEntity.ok(usersDTO);
        }
        else{
            User user = userRepository.findById(userName).orElseThrow(()->new UserNotFoundException("user with the given userName doesn't Exist"));
            return ResponseEntity.ok(Collections.singletonList(convertToDTO(user)));
        }
    }

    @Transactional
    public ResponseEntity<?> addUser(UserDTO user) {
            if(user==null)
                return ResponseEntity.badRequest().body("User data cannot be null");

            if(user.getUserName() ==null || user.getUserName().isEmpty() )
                return ResponseEntity.badRequest().body("Username cannot be empty");

            if(user.getFullName() ==null || user.getFullName().isEmpty() )
                return ResponseEntity.badRequest().body("Full name cannot be empty");

            if(user.getType()!=null&& !EnumSet.allOf(UserType.class).contains(user.getType()))
                return ResponseEntity.badRequest().body("User Type is not proper");


            if(userRepository.existsById(user.getUserName()))
                throw new UserAlreadyExistException("User already exists with username: " + user.getUserName());

            try{
            User newUser = new User();
            newUser.setFullName(user.getFullName());
            newUser.setUserName(user.getUserName());
            newUser.setType(user.getType()!=null?user.getType():ADMIN);
            newUser.setCreatedAt(LocalDateTime.now());

            User savedUser = userRepository.save(newUser);

            //convert to DTO and return

            UserDTO responseDTO = convertToDTO(savedUser);
            return ResponseEntity.ok(responseDTO);

        } catch(DataAccessException e) {  // Catch specific database-related exceptions
                log.error("Database error while adding user: {}", e.getMessage());
                return ResponseEntity.badRequest().body("Database error occurred");
            }
            catch(Exception e){
            log.error("Exception caught in UserServiceImpl: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Something went wrong");
        }

    }

    @Transactional
    public ResponseEntity<?> updateUser(String userName, UpdateUserDTO user) {
        if(user==null)
            return ResponseEntity.badRequest().body("User data cannot be null for updation");

        if (user.getType() != null && !EnumSet.allOf(UserType.class).contains(user.getType())) {
            return ResponseEntity.badRequest()
                    .body("Invalid user type. Must be one of: " + Arrays.toString(UserType.values()));
        }


        User newUser = userRepository.findById(userName).orElseThrow(()->new UserNotFoundException("User not found"));

        if(user.getFullName() !=null)
          newUser.setFullName(user.getFullName());

        newUser.setType(user.getType()!=null?user.getType():ADMIN);

        User updatedUser = userRepository.save(newUser);
        return ResponseEntity.ok(convertToDTO(updatedUser));

    }

    @Transactional
    public ResponseEntity<?> deleteUser(String userName){
        User user = userRepository.findById(userName).orElseThrow(()->new UserNotFoundException("User not found"));
        userRepository.delete(user);
        return ResponseEntity.ok("User deleted successfully");
    }

    private UserDTO convertToDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setFullName(user.getFullName());
        dto.setUserName(user.getUserName());
        dto.setType(user.getType());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }


}
