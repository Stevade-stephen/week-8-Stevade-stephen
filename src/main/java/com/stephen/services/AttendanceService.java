package com.stephen.services;

import com.stephen.models.Attendance;
import com.stephen.models.Employee;

import java.util.List;

public interface AttendanceService {

    Attendance addEmployeeAttendance(Attendance attendance, Employee employee);
    List<Attendance> getAttendanceByEmployee(Employee employee);

}
