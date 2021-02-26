package com.stephen.services;

import com.stephen.exception.EmployeeNotFoundException;
import com.stephen.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id) throws EmployeeNotFoundException;
    void deleteEmployeeById(long id);
}
