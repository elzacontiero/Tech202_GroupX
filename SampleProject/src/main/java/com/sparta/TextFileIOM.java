package com.sparta;




import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFileIOM {


    /*public static void readFile(String fileName){

        FileReader fr=null;

        try {

             fr=new FileReader(fileName);

             int readValue;

            while((readValue=fr.read()) != -1){

                System.out.println((char)readValue);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }*/

    public static ArrayList<String> readFile(String fileName) {

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }// the close() method of the resource is called

        return lines;

    }


    public static void readFileCsv(String fileName) {

        System.out.println("Writing as array of strings");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                var splitLine = line.split(",");
                //System.out.println(line);
                System.out.println(Arrays.toString(splitLine));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }// the close() method of the resource is called

    }

    public static void readWriteFile(String inFile, String outFile) {

        try (BufferedReader br = new BufferedReader(new FileReader(inFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {

            String line;
            while ((line = br.readLine()) != null) {

                bw.write(line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }// the close() method of the resource is called

    }

    public static String readFromXmlOrJSON(String filename) {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {

                sb.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}