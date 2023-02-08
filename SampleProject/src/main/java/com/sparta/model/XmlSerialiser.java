package com.sparta.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlSerialiser implements ISerialiser {

    XmlMapper mapper=new XmlMapper();

    @Override
    public String employeesToString(Employee[] emps) throws JsonProcessingException {
        return mapper.writeValueAsString(emps);
    }

    @Override
    public Employee[] stringToEmployees(String s) throws JsonProcessingException {
        return mapper.readValue(s, new TypeReference<Employee[]>() {});
    }

    //Serialisation object to file
    @Override
    public void employeesToFile(String pathname, Employee[] emps) throws IOException {

        mapper.writeValue(new File(pathname),emps);

    }

    //Deserialisation file to object
    @Override
    public Employee[] fileToEmployees(String pathname) throws IOException {

        return mapper.readValue(new File(pathname),new TypeReference<Employee[]>() {});
    }
}
