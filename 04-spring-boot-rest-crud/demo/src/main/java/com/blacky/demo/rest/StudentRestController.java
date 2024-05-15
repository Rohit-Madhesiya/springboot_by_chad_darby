package com.blacky.demo.rest;

import com.blacky.demo.StudentErrorResponse;
import com.blacky.demo.entity.Student;
import com.blacky.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
  private List<Student> theStudents;
  @PostConstruct
  public void loadData(){
    theStudents = new ArrayList<>();
    theStudents.add(new Student("Rohit", "Gupta"));
    theStudents.add(new Student("Shivam","Gupta"));
    theStudents.add(new Student("Anubhav","Tiwari"));
  }

//  @GetMapping("/students")
//    public List<Student> getStudents() {
//      List<Student> theStudents = new ArrayList<>();
//      theStudents.add(new Student("Rohit", "Gupta"));
//      theStudents.add(new Student("Shivam","Gupta"));
//      theStudents.add(new Student("Anubhav","Tiwari"));
//      return theStudents;
//  }

//  define endpoint or "/students/{studentId}" - return student at index
  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId){
    if(studentId>=theStudents.size()||studentId<0){
      throw new StudentNotFoundException("Student id not found - "+studentId);
    }
    return theStudents.get(studentId);
  }

//  @ExceptionHandler
//  public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//    StudentErrorResponse error=new StudentErrorResponse();
//    error.setStatus(HttpStatus.NOT_FOUND.value());
//    error.setMessage(exc.getMessage());
//    error.setTimeStamp(System.currentTimeMillis());
//    return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//  }
//  @ExceptionHandler
//  public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//    StudentErrorResponse error=new StudentErrorResponse();
//    error.setStatus(HttpStatus.BAD_REQUEST.value());
//    error.setMessage(exc.getMessage());
//    error.setTimeStamp(System.currentTimeMillis());
//    return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//  }

}
