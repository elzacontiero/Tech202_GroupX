package com.sparta;

import java.util.regex.Pattern;

public class Validate {
    public static void main(String[] args) {
        validateEmpNo("5e5e4");


    }

    public static boolean validateEmpNo(String empNo){
        return Pattern.matches("[0-9]{1,8}+", empNo);
    }

    public static boolean validateName(String name){
        return Pattern.matches("[a-zA-z]+", name);
    }
    public static boolean validateGender(String gender){
        return Pattern.matches("[FMX]+", gender);
    }

    public static boolean validateDate(String date){
//        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
//        String dateString = simpleDate.format(date);
        return Pattern.matches("\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]$)",date);
    }
}

