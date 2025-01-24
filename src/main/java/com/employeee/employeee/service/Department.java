package com.employeee.employeee.service;

import com.employeee.employeee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class Department {

    //string=employee name=key,string dep name as value
    Map<String,Employee>employeeDepartment=new HashMap<>();


    public void addEmployee(Employee employee,String department){
 //stores emp name to the dep
    employeeDepartment.put(department,employee);
    }

    public Employee getEmployeeDepartment(Employee employee){
        //fetch th e
return employeeDepartment.get(employee);
       //return Map.of(employeeDepartment.get(employee));

    }


}
