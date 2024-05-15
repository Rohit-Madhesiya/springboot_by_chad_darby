package com.rg.springboot.thymeleafdemo.controller;

import com.rg.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    private List<String> countries;
    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
//        create a student object
        Student theStudent=new Student();
//        add student object to the model attribute
        theModel.addAttribute("student",theStudent);
//        add the list of countries to the model
        theModel.addAttribute("countries",countries);
//        add the list of languages to the model
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("operatingsystems",operatingSystems);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent ){
//         log the input data
        System.out.println("theStudent:" +theStudent.getFirstName()+" "+theStudent.getLastName()+" "+theStudent.getCountry());
        System.out.println("Language: "+theStudent.getLanguage());
        System.out.println("Favourite Operating System: "+theStudent.getFavOperatingSystem());
        return "student-confirmation";
    }

}
