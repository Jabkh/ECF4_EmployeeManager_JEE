package com.example.employeemanager.dto.dtoConverters;

import com.example.employeemanager.dto.DepartmentDTO;
import com.example.employeemanager.model.Department;
import com.example.employeemanager.model.Job;
import com.example.employeemanager.model.Employee;
import java.util.stream.Collectors;

public class DepartmentToDTOConverter {

    public static DepartmentDTO convert(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
        departmentDTO.setJobIds(department.getJobs().stream().map(Job::getId).collect(Collectors.toList()));
        departmentDTO.setEmployeeIds(department.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        return departmentDTO;
    }
}