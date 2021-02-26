package com.stephen.controllers;

import com.stephen.models.Admin;
import com.stephen.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     *
     * @param model takes in a model and maps it to an admin
     * @return a page for login
     */
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "login";
    }

    /**
     *
     * @param admin checks if the admin is verified by inputting the correct password.
     * @param session
     * @return the home page if the admin is verified ot the login page again if not verified.
     */
    @PostMapping("/login")
    public String processLogin(@ModelAttribute Admin admin, HttpSession session) {
        if(adminService.verifyLogin(admin)){
            session.setAttribute("admin", admin);
            return "redirect:/employee";
        }
        return "redirect:/";
    }

}
