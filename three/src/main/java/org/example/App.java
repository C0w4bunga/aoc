package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException {

        List<String> binList = new ArrayList<>(Files.readAllLines(Paths.get("src/main/resources/input.txt")));

        //1)
        String gamma = "";
        String epsilon = "";
        String temp;

        for (int i =  0; i < binList.get(0).length();i++){

            temp="";

            for (String e: binList) {
                temp += e.substring(i,i+1);
            }

            long count0 = temp.chars().filter(ch -> ch == '0').count();
            long count1 = temp.chars().filter(ch -> ch == '1').count();

            if(count0 > count1){
                gamma += "0";
                epsilon += "1";
            } else {
                gamma += "1";
                epsilon += "0";
            }
        }

        System.out.println("Gamma: " + Integer.parseInt(gamma,2));
        System.out.println("Epsilon: " + Integer.parseInt(epsilon,2));
        System.out.println("Consumption: " + (Integer.parseInt(gamma,2))*(Integer.parseInt(epsilon,2)));

        //2)
        List<String> oxy  = binList;
        List<String> co2  = binList;
        String temp2;

        for (int i =  0; i < binList.get(0).length();i++){

            temp = "";
            temp2 = "";
            long count0;
            long count1;
            int finalI = i;

            if (oxy.size() > 1){
                for (String e: oxy) {
                    temp += e.substring(i,i+1);
                }

                count0 = temp.chars().filter(ch -> ch == '0').count();
                count1 = temp.chars().filter(ch -> ch == '1').count();


                if(count0 > count1){

                    oxy=oxy.stream().filter(string -> string.charAt(finalI) == '0').collect(Collectors.toList());


                } else {

                    oxy=oxy.stream().filter(string -> string.charAt(finalI) == '1').collect(Collectors.toList());

                }
            }

            if(co2.size() > 1){
                for (String e: co2) {
                    temp2 += e.substring(i,i+1);
                }

                count0 = temp2.chars().filter(ch -> ch == '0').count();
                count1 = temp2.chars().filter(ch -> ch == '1').count();

                if(count0 > count1){


                    co2=co2.stream().filter(string -> string.charAt(finalI) == '1').collect(Collectors.toList());


                } else {


                    co2=co2.stream().filter(string -> string.charAt(finalI) == '0').collect(Collectors.toList());

                }
            }
        }
        System.out.println("oxy: " + Integer.parseInt(oxy.get(0),2));
        System.out.println("co2: " + Integer.parseInt(co2.get(0),2));
        System.out.println("lsr: " + (Integer.parseInt(oxy.get(0),2))*(Integer.parseInt(co2.get(0),2)));
    }
}

