package com.employeee.employeee.controller;

import com.employeee.employeee.model.Employee;
import com.employeee.employeee.service.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // POST = Add/Create
    @PostMapping("/save")
    public ResponseEntity<Employee> create(@RequestBody  Employee employee) {
        if (employeeService.saveEmployee(employee)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(employee);

        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(employee);


        }


    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("name") String name) {

        Employee employee = employeeService.findByName(name);

        if (employee != null) {
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = employeeService.findAllEmployees();

        if (!employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(employees);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.updateEmployee(employee);

        if (updatedEmployee != null) {

            return ResponseEntity.ok(updatedEmployee);
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        boolean isDeleted = employeeService.deleteEmployee(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}



//  }






