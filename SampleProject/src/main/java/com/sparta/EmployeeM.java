package com.sparta;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import java.util.Date;
import java.util.Objects;

public class EmployeeM {

    private String employeeNo;
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private char gender;
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateOfJoining;


    public EmployeeM() {
    }

    public EmployeeM(String employeeNo, Date DOB, String firstName, String lastName,
                     char gender, Date dateOfJoining) {

        this.employeeNo = employeeNo;
        this.dateOfBirth = DOB;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfJoining = dateOfJoining;

    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeM employee = (EmployeeM) o;
        return gender == employee.gender && Objects.equals(employeeNo, employee.employeeNo) && Objects.equals(dateOfBirth, employee.dateOfBirth) && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(dateOfJoining, employee.dateOfJoining);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo, dateOfBirth, firstName, lastName, gender, dateOfJoining);
    }
}