package com.stephen.controllers;

import com.stephen.exception.EmployeeNotFoundException;
import com.stephen.models.Admin;
import com.stephen.models.Employee;
import com.stephen.services.AdminService;
import com.stephen.services.AttendanceService;
import com.stephen.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final AdminService adminService;
    private final AttendanceService attendanceService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AdminService adminService,AttendanceService attendanceService) {
        this.employeeService = employeeService;
        this.adminService = adminService;
        this.attendanceService = attendanceService;
    }

    /**
     * this is for viewing the page after login.
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/employee")
    public String viewHomePage(Model model, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin != null && adminService.verifyLogin(admin)) {
            model.addAttribute("listEmployees", employeeService.getAllEmployees());
            return "index";
        }
        return "redirect:/";
    }

    // This is to display a form to add a new employee
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";

    }

    //This is to save the employee
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employee";

    }

    //This is to update te details of an employee by id
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    //This is to delete an employee by id
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee";
    }

    //This is to view a particular employee details by his id.
    @GetMapping("/viewEmployeeDetails/{id}")
    public String viewEmployeeDetails(@PathVariable Long id, Model model, HttpSession session) throws EmployeeNotFoundException {
        Employee employee = employeeService.getEmployeeById(id);
        session.setAttribute("employee", employee);
        model.addAttribute("employee", employee);
        model.addAttribute("employeeAttendance", attendanceService.getAttendanceByEmployee(employee));
        return "view-employee-details";
    }
}
