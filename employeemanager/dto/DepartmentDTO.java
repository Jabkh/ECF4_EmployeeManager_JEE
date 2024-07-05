package com.example.employeemanager.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private int id;
    private String name;
    private List<Integer> jobIds;
    private List<Integer> employeeIds;
}