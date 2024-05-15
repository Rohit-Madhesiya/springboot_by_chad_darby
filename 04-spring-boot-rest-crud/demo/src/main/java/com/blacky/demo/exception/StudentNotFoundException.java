package com.blacky.demo.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String mesagge) {
        super(mesagge);
    }
}
