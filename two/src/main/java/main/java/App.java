package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        List<String> input = Files.readAllLines(Paths.get("src/main/resources/input.txt"));
        ArrayList<CourseData> courseDataList = new ArrayList<>();

        for (String s : input) {
            String[] splittedString = s.split("\\s+");
            courseDataList.add(new CourseData(splittedString[0], Integer.parseInt(splittedString[1])));
        }

        // 1)
        int depth = 0;
        int horizontal = 0;

        for (CourseData e: courseDataList) {

            if(e.getDirection().equals("up")){
                depth -= e.getUnit();
            }
            else if(e.getDirection().equals("down")){
                depth += e.getUnit();
            }
            else {
                horizontal += e.getUnit();
            }
        }

        System.out.println("depth1: " + depth);
        System.out.println("horizontal1: " + horizontal);
        System.out.println("result1: " + depth*horizontal);

        // 2)
        int aim = 0;
        int depth2 = 0;
        int horizontal2 = 0;

        for (CourseData e: courseDataList) {

            if(e.getDirection().equals("up")){
                aim -= e.getUnit();
            }
            else if(e.getDirection().equals("down")){
                aim += e.getUnit();
            }
            else {
                horizontal2 += e.getUnit();
                depth2 += aim*e.getUnit();
            }
        }

        System.out.println("depth2: " + depth2);
        System.out.println("horizontal2: " + horizontal2);
        System.out.println("result2: " + depth2*horizontal2);
    }
}
