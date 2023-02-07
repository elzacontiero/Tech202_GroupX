package com.sparta;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFileIO {
    //Long way of trying and catching

//    public static void readFile(String fileName) {
//        FileReader fr = null;
//        try {
//            fr = new FileReader(fileName);
//            int readValue;
//            while ((readValue = fr.read()) != -1) {
//                System.out.println((char) readValue);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//
//                fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//    }

    public static String readFile(String fileName) {
        String line="";
        try(BufferedReader br = new BufferedReader( new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
    public static void readFileCsv(String fileName) {
        try(BufferedReader br = new BufferedReader( new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                var splitLine = line.split(",");
                System.out.println(Arrays.toString(splitLine));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<String> readFileLines(String fileName){
        ArrayList<String>arrayLines = new ArrayList();
        try(BufferedReader br = new BufferedReader( new FileReader(fileName))) {

            String line;

            while ((line = br.readLine()) != null) {
                arrayLines.add(line);
            }
            for(String s : arrayLines){
                System.out.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayLines;
    }

    public static void readWriteFile(String inFileName, String outFileName ) {
        try(BufferedReader br = new BufferedReader( new FileReader(inFileName));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outFileName))) {
            String line="";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line +"\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


