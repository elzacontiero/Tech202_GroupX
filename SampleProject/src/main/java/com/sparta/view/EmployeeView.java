package com.sparta.view;

import com.sparta.controller.EmployeeController;
import com.sparta.model.Employee;
import com.sparta.model.ISerialiser;

import java.io.IOException;
import java.util.Scanner;

public class EmployeeView {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println(" What type input serialiser would you like?");
        System.out.println("[J] - Json, [X] - XML, [C] - Csv ");

        String inputSerialiser=sc.nextLine();

        ISerialiser input= SerialiserFactory.getSerialiser(inputSerialiser);

        System.out.println("Please enter a file path to read from:");
        String filepathin=sc.nextLine();

        System.out.println(" What type output serialiser would you like?");
        System.out.println("[J] - Json, [X] - XML, [C] - Csv ");

        String outputSerialiser=sc.nextLine();

        ISerialiser output=SerialiserFactory.getSerialiser(outputSerialiser);

        System.out.println("Please enter a file path to read from:");
        String filepathout=sc.nextLine();

        EmployeeController controller=new EmployeeController(input);
        Employee[] emps;
        try {

            emps=controller.deserialise(filepathin);
            controller.setObj(output);
            controller.serialise(filepathout,emps);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
