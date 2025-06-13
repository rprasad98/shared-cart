package com.example.demo.Exception;


public class UserAlreadyExistException extends RuntimeException{

    public UserAlreadyExistException(String msg) {
        super(msg);
    }
}
