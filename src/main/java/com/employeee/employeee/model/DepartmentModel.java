package com.employeee.employeee.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import jakarta.persistence.*;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

@Entity
public  class DepartmentModel {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public String getEmployeeMapJson() {
        return employeeMapJson;
    }

    public void setEmployeeMapJson(String employeeMapJson) {
        this.employeeMapJson = employeeMapJson;
    }

    @Column(columnDefinition = "TEXT")
    private String employeeMapJson;

    public Map<String, Employee> getEmployeeMap() throws JsonProcessingException {
        return convertJsonToMap(employeeMapJson);
    }


    public Map<String , Employee> convertJsonToMap(String employeeMapJson) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // Parse the JSON string into a Map<Employee, String>
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        Map<String, Employee> employeeMap = objectMapper.readValue(
                employeeMapJson,
                typeFactory.constructMapType(HashMap.class, String.class, Employee.class)
        );

        // Return the resulting map
        return employeeMap;

    }


}
