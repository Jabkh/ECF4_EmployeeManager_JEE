package com.example.employeemanager.service;

import com.example.employeemanager.model.Job;
import com.example.employeemanager.repository.HibernateUtil;
import com.example.employeemanager.repository.job.JobRepository;
import com.example.employeemanager.repository.job.JobRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class JobService {

    private JobRepository jobRepository;

    public JobService() {
        this.jobRepository = new JobRepositoryImpl(HibernateUtil.getSessionFactory());
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public Job getJobById(int id) {
        return jobRepository.findById(id);
    }

    public void saveJob(Job job) {
        jobRepository.save(job);
    }

    public void updateJob(Job job) {
        jobRepository.update(job);
    }

    public void deleteJobById(int id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getJobsByEmployeeId(int employeeId) {
        return jobRepository.findByEmployeeId(employeeId);
    }
}