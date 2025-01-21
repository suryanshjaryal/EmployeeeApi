package com.employeee.employeee.service;

import com.employeee.employeee.exception.EmployeeAlreadyExistsException;
import com.employeee.employeee.model.Employee;
import com.employeee.employeee.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public boolean saveEmployee(Employee employee) {
        if (employeeRepository.existsByName(String.valueOf(employee.getName()))) {
            throw new EmployeeAlreadyExistsException("Employee with name " + employee.getName() + " " + "Already Exists " + "Status Code = " + HttpStatus.CONFLICT);

        } else {
            employeeRepository.save(employee);
            return true;
        }
    }

    public Employee getEmployeeByName(String name) {
        return (Employee) employeeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Employee with name " + name + " not found."));
    }

    public Employee findByName(String name) {
        return null;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())){
            return employeeRepository.save(employee);
        }
        return null;
    }

    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}








