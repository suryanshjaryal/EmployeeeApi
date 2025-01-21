package com.employeee.employeee.repository;

import com.employeee.employeee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    boolean existsByName(String employee);

    <T> ScopedValue<T> findByName(String name);



}
