import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Part 1:");
        part1();
        System.out.println("Part 2:");
        part2();
    }

    public static void part1() throws FileNotFoundException, IOException {

        ArrayList<Bag_Day2> bagList = new ArrayList<>();
        String filepath = "./input/InputDay2";
        String regex = "Game (\\d+):((?:\\s*(\\d+)\\s*([a-zA-Z]+),?;?)+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String line;
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while((line = reader.readLine()) != null){
                matcher = pattern.matcher(line);
                while( matcher.find()){
                    Boolean flag = true;
                    int id = Integer.parseInt(matcher.group(1));
                    String group2 = matcher.group(2);
                    Pattern valuesPattern = Pattern.compile("(\\d+)\\s*([a-zA-Z]+)");
                    Matcher valuesMatcher = valuesPattern.matcher(group2);

                    while(valuesMatcher.find()){
                        int quantity = Integer.parseInt(valuesMatcher.group(1));
                        String color = valuesMatcher.group(2);
                        switch (color){
                            case "red":
                                if(quantity > 12 ){
                                    flag = false;
                                }
                                break;
                            case "blue":
                                if(quantity > 14)
                                    flag = false;
                                break;
                            case "green":
                                if(quantity > 13)
                                    flag = false;
                                break;

                        }

                    }
                    if(flag){
                        sum = sum + id;
                    }

                }
            }
        }
        System.out.println(sum);
    }
    public static void part2() throws FileNotFoundException, IOException{
        ArrayList<Bag_Day2> bagList = new ArrayList<>();
        String filepath = "./input/InputDay2";
        String regex = "Game (\\d+):((?:\\s*(\\d+)\\s*([a-zA-Z]+),?;?)+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String line;
        long sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            while((line = reader.readLine()) != null){
                matcher = pattern.matcher(line);
                while( matcher.find()){
                    int maxred = 0;
                    int maxblue = 0;
                    int maxgreen = 0;
                    int id = Integer.parseInt(matcher.group(1));
                    String group2 = matcher.group(2);
                    Pattern valuesPattern = Pattern.compile("(\\d+)\\s*([a-zA-Z]+)");
                    Matcher valuesMatcher = valuesPattern.matcher(group2);

                    while(valuesMatcher.find()){
                        int quantity = Integer.parseInt(valuesMatcher.group(1));
                        String color = valuesMatcher.group(2);
                        switch (color){
                            case "red":
                                if(quantity > maxred){
                                    maxred = quantity;
                                }
                                break;
                            case "blue":
                                if(quantity > maxblue)
                                    maxblue = quantity;
                                break;
                            case "green":
                                if(quantity > maxgreen){
                                    maxgreen = quantity;
                                }
                                break;

                        }

                    }
                    long power = (long) maxred * maxgreen * maxblue;
                    sum = sum + power;

                }
            }
        }
        System.out.println(sum);
    }
}
