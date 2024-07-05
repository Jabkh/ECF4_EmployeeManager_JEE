package com.example.employeemanager.repository.job;

import com.example.employeemanager.model.Job;
import com.example.employeemanager.repository.BaseRepository;

import java.util.List;

public interface JobRepository extends BaseRepository<Job> {
    List<Job> findByEmployeeId(int employeeId);
}