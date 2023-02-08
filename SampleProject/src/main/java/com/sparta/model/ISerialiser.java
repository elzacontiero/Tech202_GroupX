package com.sparta.model;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public interface ISerialiser {

    public String employeesToString(Employee[] emps) throws JsonProcessingException;
    public Employee[] stringToEmployees(String s) throws JsonProcessingException;
    public void employeesToFile(String pathname, Employee[] emps) throws IOException;
    public Employee[] fileToEmployees(String pathname) throws IOException;

}
