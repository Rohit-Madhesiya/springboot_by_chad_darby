package com.blacky.demo.rest;

import com.blacky.demo.StudentErrorResponse;
import com.blacky.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
//    Add Exception Handling code here
      @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
    StudentErrorResponse error=new StudentErrorResponse();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
  }
      @ExceptionHandler
  public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
    StudentErrorResponse error=new StudentErrorResponse();
    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());
    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
  }
}
