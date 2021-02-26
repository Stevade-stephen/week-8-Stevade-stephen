package com.stephen.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Employee extends BaseModel {

    @Column(name = "first_names")
    private String firstName;

    @Column(name = "last_names")
    private String lastName;

    @Column(name = "emails", unique = true)
    private String email;

    @Column(name = "phone_numbers", unique = true)
    private String phoneNumber;

    private String age;

    private String position;

    @Column(name = "leave_statuses")
    private String leaveStatus;

    @Column(name = "nature_of_leave")
    private String natureOfLeave;

    @Column(name = "state_of_origin")
    private String stateOfOrigin;

    @Column(name = "marital_status")
    private String maritalStatus;

    private String religion;

    private String qualification;

    @Column(name = "years_of_experience")
    private String yearsOfExperience;


    private String address;

    private String salary;




    @OneToMany
    private List<Attendance> attendances;

}
