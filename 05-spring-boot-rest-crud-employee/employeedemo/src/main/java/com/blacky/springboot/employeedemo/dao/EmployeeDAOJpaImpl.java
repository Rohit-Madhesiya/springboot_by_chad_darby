package com.blacky.springboot.employeedemo.dao;

import com.blacky.springboot.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entity manager
private EntityManager entityManager;
//    set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
//        create a query
        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee",Employee.class);

//        execute query and get result list
        List<Employee> lists=theQuery.getResultList();
//        return the results
        return lists;
    }

    @Override
    public Employee findById(int theId) {
//        get employee
        Employee theEmployee=entityManager.find(Employee.class,theId);
//        return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
//        save employee
//        if id==0 ->insert/save else update
        Employee dbEmployee=entityManager.merge(theEmployee);

//        return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
//    find empoyeee by id
        Employee theEmployee=entityManager.find(Employee.class,theId);
//        remove employee
        entityManager.remove(theEmployee);
    }

}
