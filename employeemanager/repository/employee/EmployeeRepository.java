package com.example.employeemanager.repository.employee;

import com.example.employeemanager.model.Employee;
import com.example.employeemanager.repository.BaseRepository;

import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findByJobId(int jobId);
    List<Employee> findByDepartmentId(int departementId);
}