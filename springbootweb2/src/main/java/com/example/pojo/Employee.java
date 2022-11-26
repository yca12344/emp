package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

//员工表
@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastname;
    private String email;
    private Integer gender; //0:男 1：女
    private Department department;
    private String birth;

    public Employee(Integer id, String lastname, String email, Integer gender, Department department,String date) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = date;
    }
}
