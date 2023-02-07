package com.sparta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String emp_no;
    private String birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private String hire_date;


    public String getEmp_no() {
        return emp_no;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getGender() {
        return gender;
    }

    public String getHire_date() {
        return hire_date;
    }

    public Employee(){}
    public Employee(String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
        this.emp_no = emp_no;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.hire_date = hire_date;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "emp_no='" + emp_no + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date=" + birth_date +
                ", gender=" + gender +
                ", hire_date=" + hire_date +
                '}';
    }
}




