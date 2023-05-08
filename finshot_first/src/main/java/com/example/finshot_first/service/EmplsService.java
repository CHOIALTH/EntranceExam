package com.example.finshot_first.service;

import com.example.finshot_first.domain.Employees;

import java.util.List;

public interface EmplsService {
    void addEmployee(Employees employees);
    List<Employees> getAllEmployees();
    void updateEmployee(Employees employees);
    void deleteEmployee(int id);

}
