package com.sparta;

import java.util.regex.Pattern;

public class RegexValidation {

    public static boolean validateEmployeeNumber(String empNo){

        return Pattern.matches("[0-9]{1,8}",empNo);

    }

    public static boolean validateDate(String date){

        //return Pattern.matches("[0-9]{2}[/-][0-9]{2}[/-][0-9]{4}",date);

        return Pattern.matches("([0-3][0-9][/-]((0[1-9])|(1[0-2]))[/-][0-9]{4})|([0-9]{4}[/-]((0[1-9])|(1[0-2]))[/-][0-3][0-9])",date);

        //return Pattern.matches("([0-9]{4}-((0[0-9])|(1[0-2]))-[0-3][0-9])",date);

        //return date.matches("[0-9]{2}[/-][0-9]{2}[/-][0-9]{4}") || date.matches("[0-9]{4}[/-][0-9]{2}[/-][0-9]{2}");
    }



    public static boolean validateName(String name){

        //return Pattern.matches("[a-zA-z]+",name);
        return name.matches("[a-zA-Z]+");
    }

    public static  boolean validateGender(String gender){

        return Pattern.matches("[MFX]",gender);
    }





}
