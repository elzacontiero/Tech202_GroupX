package com.sparta.view;

import com.sparta.model.ISerialiser;
import com.sparta.model.JsonSerialiser;
import com.sparta.model.XmlSerialiser;

public class SerialiserFactory {

    public  static ISerialiser getSerialiser(String option){
        switch (option){
            case "J":
            case "j":
                return new JsonSerialiser();
            case "X":
            case "x":
                return new XmlSerialiser();
            default:
                throw new IllegalArgumentException("Select correct option");
        }
    }
}
