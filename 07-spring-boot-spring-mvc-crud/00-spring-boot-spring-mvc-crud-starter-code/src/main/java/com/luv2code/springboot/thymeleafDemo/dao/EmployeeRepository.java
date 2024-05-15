package com.luv2code.springboot.thymeleafDemo.dao;

import com.luv2code.springboot.thymeleafDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!
//add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();
}
