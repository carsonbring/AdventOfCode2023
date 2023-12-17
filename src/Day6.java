import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filepath = "./input/InputDay6";
        int counter = 0;
        Map<String, ArrayList<Integer>> timeDist = new HashMap<>();
        String regex = "\\b(\\d+)\\b";
        String line;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            while( (line = reader.readLine()) != null){
                ArrayList<Integer> tempArray = new ArrayList<>();
                if(counter == 0){
                    matcher = pattern.matcher(line);
                    while(matcher.find()){
                        tempArray.add(Integer.parseInt(matcher.group(1)));
                    }
                    timeDist.put("times", tempArray);
                }
                if(counter == 1){
                    matcher = pattern.matcher(line);
                    while(matcher.find()){
                        tempArray.add(Integer.parseInt(matcher.group(1)));
                    }
                    timeDist.put("dists", tempArray);
                }
                counter++;
            }


        }
        System.out.println("Part 1");
        part1(timeDist);
        System.out.println("Part 2");
        part2(timeDist);
    }
    public static void part1(Map<String, ArrayList<Integer>>  map) throws FileNotFoundException, IOException {
        ArrayList<Integer> waysToWin = new ArrayList<>();
        for(int i = 0; i < map.get("times").size(); i++){
            //Individual races
            int numWins = 0;
            Integer time = map.get("times").get(i);
            Integer dist = map.get("dists").get(i);

            for(int rate = 1; rate < time; rate++ ){
                int timeToComplete = time - rate;
                if( rate * timeToComplete >= dist){
                    numWins++;
                }
            }
            waysToWin.add(numWins);
        }
        int answer = 1;
        for( int i = 0; i < waysToWin.size(); i++){
            answer = answer * waysToWin.get(i);
        }
        System.out.println(answer);
    }
    public static void part2(Map<String, ArrayList<Integer>> map) throws FileNotFoundException, IOException {

    }
}
