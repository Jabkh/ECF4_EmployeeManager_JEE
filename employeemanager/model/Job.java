package com.example.employeemanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    // One Job can have many Employees
    @OneToMany(mappedBy = "job")
    private List<Employee> employees;

    // Many Jobs can belong to one Department
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
