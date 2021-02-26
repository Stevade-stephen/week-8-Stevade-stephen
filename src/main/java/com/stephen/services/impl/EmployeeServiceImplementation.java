package com.stephen.services.impl;

import com.stephen.exception.EmployeeNotFoundException;
import com.stephen.models.Employee;
import com.stephen.repositories.EmployeeRepository;
import com.stephen.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //This is to get an employee by id
    @Override
    public Employee getEmployeeById(long id) throws EmployeeNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee;
        if(optional.isPresent()){
            employee = optional.get();
        } else {
            throw new EmployeeNotFoundException(" employee not found for id " + id);
        }
        return employee;
    }

    //To delete an employee
    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }
}
