package com.sparta;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class EmployeeUtilitiesM {

    private static ArrayList<String> faultyEmployees=new ArrayList<>();
    private  static Logger logger= LogManager.getLogger(" Employee App ");
    private static ObjectMapper jsonMapper=new ObjectMapper();

    private static XmlMapper xmlMapper=new XmlMapper();

    static {
        jsonMapper.setTimeZone(TimeZone.getDefault());
        xmlMapper.setTimeZone(TimeZone.getDefault());
    }

    public static EmployeeM createEmployee(String line) throws IncorrectFormatException, ParseException {

        String[] employeeDetails=line.split(",");

        boolean status=validateEmployeeDetails(employeeDetails);

        if(status==false){

            faultyEmployees.add(line);
            throw new IncorrectFormatException("Wrong input format in csv -> "+line);
        }
        else{

            SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");

            Date dob=df.parse(employeeDetails[1]);
            Date joiningDate=df.parse(employeeDetails[5]);

            EmployeeM myEmployee=new EmployeeM(employeeDetails[0],dob,
                    employeeDetails[2],employeeDetails[3],employeeDetails[4].charAt(0),joiningDate);

            return myEmployee;

        }

    }

    public static ArrayList<EmployeeM> readEmployeesFromCsv(String fileName){

        ArrayList<EmployeeM> myList=new ArrayList<>();

        var empdetails= TextFileIOM.readFile(fileName);

        for(String line:empdetails){

            EmployeeM e= null;

            try {

                e = createEmployee(line);
                myList.add(e);
            }
            catch (IncorrectFormatException ex) {
                logger.catching(ex);
            }
            catch (ParseException ex) {
                logger.catching(ex);
            }

        }

       return myList;

    }

    public static boolean validateEmployeeDetails(String[] empDetails){

        return  empDetails.length==6 &&
                RegexValidation.validateEmployeeNumber(empDetails[0]) &&
                RegexValidation.validateDate(empDetails[1]) &&
                RegexValidation.validateName(empDetails[2]) &&
                RegexValidation.validateName(empDetails[3]) &&
                RegexValidation.validateGender(empDetails[4]) &&
                RegexValidation.validateDate(empDetails[5]);

    }

    public static void listOfEmployeesToJSON(ArrayList<EmployeeM> employees) throws IOException {



        jsonMapper.writeValue(new File("src/main/resources/employees.json"),employees);

    }

    public static void listOfEmployeesToXML(ArrayList<EmployeeM> employees) throws IOException {


        xmlMapper.writeValue(new File("src/main/resources/employees.xml"),employees);

    }

    public static ArrayList<EmployeeM> readEmployeesFromJson(String filename) throws JsonProcessingException {

        String jsonString= TextFileIOM.readFromXmlOrJSON(filename);
        return jsonMapper.readValue(jsonString, new TypeReference<ArrayList<EmployeeM>>() {});

    }

    public static ArrayList<EmployeeM> readEmployeesFromXml(String filename) throws JsonProcessingException {

        String xmlString= TextFileIOM.readFromXmlOrJSON(filename);
        return xmlMapper.readValue(xmlString, new TypeReference<ArrayList<EmployeeM>>() {});


    }


}
