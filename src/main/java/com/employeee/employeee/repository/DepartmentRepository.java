package com.employeee.employeee.repository;

import com.employeee.employeee.model.DepartmentModel;
import com.employeee.employeee.service.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface DepartmentRepository extends JpaRepository<DepartmentModel,Long> {

}
