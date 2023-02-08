package com.sparta.controller;

import com.sparta.model.Employee;
import com.sparta.model.ISerialiser;

import java.io.IOException;

public class EmployeeController {

    private ISerialiser obj;

    public void setObj(ISerialiser obj) {
        this.obj = obj;
    }

    public EmployeeController(ISerialiser obj){
        this.obj=obj;
    }

    public void serialise(String path, Employee[] emps) throws IOException {
        obj.employeesToFile(path,emps);
    }

    public Employee[] deserialise(String path) throws IOException {

        return obj.fileToEmployees(path);
    }

}
