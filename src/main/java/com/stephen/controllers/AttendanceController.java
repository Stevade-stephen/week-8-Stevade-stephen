package com.stephen.controllers;

import com.stephen.exception.EmployeeNotFoundException;
import com.stephen.models.Attendance;
import com.stephen.services.AttendanceService;
import com.stephen.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final EmployeeService employeeService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService, EmployeeService employeeService) {
        this.attendanceService = attendanceService;
        this.employeeService = employeeService;
    }
    //This is to add attendance record for the employee
    @GetMapping("{id}/attendance")
    public String attendanceForm(Model model, @PathVariable(value = "id") Long id) throws EmployeeNotFoundException {
        Attendance attendance = new Attendance();
        attendance.setEmployee(employeeService.getEmployeeById(id));
        model.addAttribute("attendance", attendance);
        return "attendance";
    }


    @PostMapping("{employeeId}/attendance")
    public String addAttendance(@ModelAttribute Attendance attendance,  @PathVariable(value = "employeeId") Long employeeId) throws EmployeeNotFoundException {
        Attendance employeeAttendance = attendanceService.addEmployeeAttendance(attendance, employeeService.getEmployeeById(employeeId) );
        return "redirect:/viewEmployeeDetails/" + employeeAttendance.getEmployee().getId();
    }
}
