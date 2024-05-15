package com.blacky.springboot.employeedemo.service;

import com.blacky.springboot.employeedemo.dao.EmployeeRepository;
import com.blacky.springboot.employeedemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepos;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepos){
        employeeRepos=theEmployeeRepos;
    }

    @Override
    public List<Employee> findAll(){
        return employeeRepos.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepos.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }else{
//            we didn't find the employee
            throw new RuntimeException("Did not find employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepos.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepos.deleteById(theId);
    }
}
