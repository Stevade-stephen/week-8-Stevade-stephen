package com.stephen.services.impl;

import com.stephen.models.Admin;
import com.stephen.services.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Override // This is to verify the admin by requiring the admin to give the user name and password below
    public Boolean verifyLogin(Admin admin) {
         return admin.getUsername().equals("admin") && admin.getPassword().equals("admin");
    }
}
