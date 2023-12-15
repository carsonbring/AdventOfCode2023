import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Day4 {
    public static void main(String[] args) throws FileNotFoundException, IOException{

        System.out.println("Part 1");
        part1();
        System.out.println("Part 2");
        part2();
    }
    public static void part1() throws FileNotFoundException, IOException{
        String filepath = "./input/InputDay4";
        String regex = "\\b(\\d+)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String line;
        int sum = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            while((line = reader.readLine()) != null){
                ArrayList<Integer> winningNums = new ArrayList<Integer>();
                ArrayList<Integer> elfNums = new ArrayList<Integer>();
                matcher = pattern.matcher(line);
                int points = 0;
                int counter = 0;
                while(matcher.find()){
                    if(counter == 0){
                        counter = counter + 1;
                        continue;
                    }
                    String match = matcher.group(1);
                    if(counter < 11){
                        winningNums.add(Integer.parseInt(match));
                    }else{
                        elfNums.add(Integer.parseInt(match));
                    }
                    counter = counter + 1;
                }
                counter =0;
                for(Integer num : winningNums){
                    if(elfNums.contains(num)){
                        if(counter == 0 ){
                            points = 1;
                        }else{
                            points = points * 2;
                        }
                        counter++;
                    }
                }
                sum = sum + points;
            }
            System.out.println(sum);
        }
    }
    public static void part2() throws FileNotFoundException, IOException{
    }

}
