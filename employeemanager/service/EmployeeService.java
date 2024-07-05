package com.example.employeemanager.service;

import com.example.employeemanager.repository.employee.EmployeeRepository;
import com.example.employeemanager.repository.employee.EmployeeRepositoryImpl;
import com.example.employeemanager.repository.HibernateUtil;
import jakarta.enterprise.context.ApplicationScoped;
import com.example.employeemanager.model.Employee;


import java.util.List;

@ApplicationScoped
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepositoryImpl(HibernateUtil.getSessionFactory());
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesByJobId(int jobId) {
        return employeeRepository.findByJobId(jobId);
    }

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }
}