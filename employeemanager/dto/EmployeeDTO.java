package com.example.employeemanager.dto;

import java.time.LocalDate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
    private int id;
    private String name;
    private String adresse;
    private LocalDate dateOfBirth;
    private int departmentId;
    private int jobId;

}