package com.sparta;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

public class EmployeeApp {

    private  static Logger logger= LogManager.getLogger(" Employee App ");

    public static void main(String[] args) {

        ArrayList<EmployeeM> employees= EmployeeUtilitiesM.readEmployeesFromCsv("src/main/resources/employees_short.csv");
        /*System.out.println("Total Employees: "+employees.size());
        for(Employee e:employees){
            System.out.println(e);
        }*/

        EmployeeM[] emps=new EmployeeM[employees.size()];
        emps=employees.toArray(emps);



        try {

            //EmployeeUtilities.listOfEmployeesToJSON(employees);
            //EmployeeUtilities.listOfEmployeesToXML(employees);

            var myJsonEmployees= EmployeeUtilitiesM.readEmployeesFromJson("src/main/resources/employees.json");
            System.out.println("------------------From Json File--------------------");
            System.out.println("Json  :   "+myJsonEmployees);

            var myXmlEmployees= EmployeeUtilitiesM.readEmployeesFromXml("src/main/resources/employees.xml");
            System.out.println("------------------From Xml File--------------------");
            System.out.println("Xml  :   "+myXmlEmployees);


        } catch (IOException  e) {
            logger.catching(e);
        }




    }
}
