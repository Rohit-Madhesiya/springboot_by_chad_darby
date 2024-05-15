package com.luv2code.springboot.thymeleafDemo.controller;

import com.luv2code.springboot.thymeleafDemo.entity.Employee;
import com.luv2code.springboot.thymeleafDemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    public EmployeeController(EmployeeService theEmployeeService){
        this.employeeService=theEmployeeService;
    }

//    add mapping for list the employee
    @GetMapping("/list")
    public String listEmployees(Model theModel){
//        get employees from DB
        List<Employee> theEmployees=employeeService.findAll();
//add to the spring model
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee")Employee theEmployee){
//        save the employee
        employeeService.save(theEmployee);

//        use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel){
        //get the employee from the service
        Employee theEmployee=employeeService.findById(id);
        // set employee as model attriute to pre-populate the form
        theModel.addAttribute("employee",theEmployee);
//      send over to our form
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }


}
