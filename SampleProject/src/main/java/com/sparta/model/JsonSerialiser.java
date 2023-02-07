package com.sparta.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
// this class JsonSerialiser has the job of taking employees
// and converting to JSon string format or file format.
// Now implement each method below.
public class JsonSerialiser implements ISerialiser {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String employeesToString(Employee[] emps) throws JsonProcessingException {
        return mapper.writeValueAsString(emps);
    }

    @Override
    public Employee[] stringToEmployees(String s) throws JsonProcessingException {
        return mapper.readValue(s, Employee[].class);
    }

    @Override
    public void employeesToFile(String pathname, Employee[] emps) throws IOException {
        mapper.writeValue(new File(pathname), emps);
    }

    @Override
    public Employee[] fileToEmployees(String pathname) throws IOException {
        return mapper.readValue(new File(pathname), Employee[].class);
    }
}
