package com.example.employeemanager.repository;

import java.util.List;

public interface BaseRepository<T> {
    List<T> findAll();
    T findById(int id);
    void save(T entity);
    void update(T entity);
    void deleteById(int id);
}