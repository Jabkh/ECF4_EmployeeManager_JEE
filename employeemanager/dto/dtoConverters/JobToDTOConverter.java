package com.example.employeemanager.dto.dtoConverters;

import com.example.employeemanager.dto.JobDTO;
import com.example.employeemanager.model.Job;
import com.example.employeemanager.model.Employee;
import java.util.stream.Collectors;

public class JobToDTOConverter {

    public static JobDTO convert(Job job) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(job.getId());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setDescription(job.getDescription());
        // Assuming job.getEmployees() returns a list of employees
        jobDTO.setEmployeeIds(job.getEmployees().stream().map(Employee::getId).collect(Collectors.toList()));
        return jobDTO;
    }
}