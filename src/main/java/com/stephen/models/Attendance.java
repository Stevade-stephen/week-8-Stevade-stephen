package com.stephen.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Data
public class Attendance extends BaseModel {

    private String weekNumber;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;

    @ManyToOne
    @JoinColumn(name = ("employee_id"))
    private Employee employee;

}
