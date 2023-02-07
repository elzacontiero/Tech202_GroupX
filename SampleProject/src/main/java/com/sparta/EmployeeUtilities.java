package com.sparta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeUtilities {
    public static void main(String[] args) {
//        Employee e1 = new Employee("52343", LocalDate.of(1987,4,30), "Lewis", "Hamilton", "M", LocalDate.of(2011,11,07));
//        Employee e2 = new Employee("48574", LocalDate.of(1973,10,01), "Sandra", "Khan", "F",LocalDate.of(2005,9,04));
//        Employee e3 = new Employee("34532", LocalDate.of(1980,10,5), "Claire", "Smith", "X", LocalDate.of(2009,1,23));

        List<Employee> employees = new ArrayList<>();
//        employees.add(e1);
//        employees.add(e2);
//        employees.add(e3);
//        EmployeeConverter conv = new EmployeeConverter();
//        try {
//
//            var result = conv.employeeTojson(employees);
//            System.out.println(result);
//        }catch(IOException e) {
//                throw new RuntimeException(e);
//            }

    }
    private static Logger logger = LogManager.getLogger("Employee app");

    public static Employee createEmployee(String line) {
        String[] values = line.split(",");
        ArrayList<String> faultyLines = new ArrayList<>();
        Employee employee = null;
        if (!(Validate.validateEmpNo(values[0]) && !(Validate.validateDate(values[1])))) {
            faultyLines.add(line);
            logger.error("The following employee details are incorrect: " + line);
        } else {

//        Date d = DateTimeApp.convertDateString(values[1]);
//        Date dh = DateTimeApp.convertDateString(values[5]);
//        Employee employee = new Employee(values[0], d, values[2], values[3], values[4], dh);
            employee = new Employee(values[0], values[1], values[2], values[3], values[4], values[5]);

        }
        return employee;
    }


    public static ArrayList<Employee> readEmployees(String fileName) {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();
        ArrayList<String> faultyLines = new ArrayList<>();
        var readLine = TextFileIO.readFileLines(fileName);
        for (String line : readLine) {
            employeeArrayList.add(createEmployee(line));
        }
        return employeeArrayList;
    }



}
