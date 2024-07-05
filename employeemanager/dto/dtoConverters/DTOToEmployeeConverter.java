package com.example.employeemanager.dto.dtoConverters;

import com.example.employeemanager.dto.EmployeeDTO;
import com.example.employeemanager.model.Employee;
import com.example.employeemanager.model.Department;
import com.example.employeemanager.model.Job;

public class DTOToEmployeeConverter {

    public static Employee convert(EmployeeDTO employeeDTO, Department department, Job job) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setName(employeeDTO.getName());
        employee.setAdresse(employeeDTO.getAdresse());
        employee.setDepartment(department);
        employee.setJob(job);
        return employee;
    }
}