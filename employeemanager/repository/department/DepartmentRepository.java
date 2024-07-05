package com.example.employeemanager.repository.department;

import com.example.employeemanager.model.Department;
import com.example.employeemanager.repository.BaseRepository;

import java.util.List;

public interface DepartmentRepository extends BaseRepository<Department> {
    List<Department> findByEmployeeId(int employeeId);
}