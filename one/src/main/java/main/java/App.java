package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        List<Integer> result = Files.readAllLines(Paths.get("src/main/resources/measurement.txt")).stream().map(Integer::parseInt).collect(Collectors.toList());
        int counter = 0;

        //1)
        for(int i = 1; i < result.size()-1; i++){
            if(result.get(i)<result.get(i+1)){
                counter++;
            }
        }
        System.out.println("1) " + counter);

        //2)
        counter = 0;
        for(int i = 1; i < result.size()-3; i++){
            if((result.get(i) + result.get(i+1) + result.get(i+2)) < (result.get(i+1) + result.get(i+2) + result.get(i+3))){
                counter++;
            }
        }
        System.out.println("2) " + counter);

    }
}
