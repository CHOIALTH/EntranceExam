package com.example.finshot_first.service;

import com.example.finshot_first.domain.Employees;
import com.example.finshot_first.mapper.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmplsServiceImpl implements EmplsService{
    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public void addEmployee(Employees employees) {
        employeesMapper.insert(employees);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesMapper.findAll();
    }

    @Override
    public void updateEmployee(Employees employees) {
        employeesMapper.update(employees);
    }

    @Override
    public void deleteEmployee(int id) {
        employeesMapper.delete(id);
    }
}
