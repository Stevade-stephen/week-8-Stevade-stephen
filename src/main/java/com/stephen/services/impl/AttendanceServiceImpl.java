package com.stephen.services.impl;

import com.stephen.models.Attendance;
import com.stephen.models.Employee;
import com.stephen.repositories.AttendanceRepository;
import com.stephen.services.AttendanceService;
import com.stephen.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeService employeeService;

    @Autowired
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository, EmployeeService employeeService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
    }


    @Override //To save the attendance..
    public Attendance addEmployeeAttendance(Attendance attendance, Employee employee) {
        attendance.setEmployee(employee);
        return attendanceRepository.save(attendance);
    }


    @Override //To return a list of attendance
    public List<Attendance> getAttendanceByEmployee(Employee employee) {
        return attendanceRepository.findAttendanceByEmployee(employee);

    }
}
