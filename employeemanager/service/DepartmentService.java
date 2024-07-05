package com.example.employeemanager.service;

import com.example.employeemanager.model.Department;
import com.example.employeemanager.repository.department.DepartmentRepository;
import com.example.employeemanager.repository.department.DepartmentRepositoryImpl;
import com.example.employeemanager.repository.HibernateUtil;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService() {
        this.departmentRepository = new DepartmentRepositoryImpl(HibernateUtil.getSessionFactory());
    }


    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void updateDepartment(Department department) {
        departmentRepository.update(department);
    }

    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

     public List<Department> getDepartmentsByEmployeeId(int employeeId) {
         return departmentRepository.findByEmployeeId(employeeId);
     }
}