import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filepath = "./input/InputDay3";
        String line;
        char[][] engine = new char[140][140];
        int counter = 0;

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            while((line = reader.readLine()) != null){
               engine[counter] = line.toCharArray();
               counter++;
            }
        }
        System.out.println("Part 1:");
        part1(engine);
        System.out.println("Part 2:");
        part2(engine);


    }
    public static void part1(char[][] engine) throws FileNotFoundException, IOException{

    }
    public static void part2(char[][] engine) throws FileNotFoundException, IOException{

    }
}
