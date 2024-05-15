package com.rg.springboot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
//    need a controller method to show intital HTML form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

//    need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
//    need a controller methos to read form data and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShoutDude(HttpServletRequest request, Model model){
//        read the request parameter from the HTML form
        String theName=request.getParameter("studentName");
//        convert the data to all caps
        theName=theName.toUpperCase();
//        create the message
        String res="Yo! "+theName;
//        add the data to the model
        model.addAttribute("message",res);
        return "helloworld";
    }
    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName")String theName, Model model){
//        convert the data to all caps
        theName=theName.toUpperCase();
//        create the message
        String res="Hey! "+theName;
//        add the data to the model
        model.addAttribute("message",res);
        return "helloworld";
    }

}
