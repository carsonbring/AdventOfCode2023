import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Part 1");
        part1();
        System.out.println("Part 2");
        part2();
    }
    public static void part1() throws FileNotFoundException, IOException{
        String filepath = "./input/InputDay5";
        String line;
        Boolean isFirstLine = true;
        String regex = "\\b(\\d+)\\b";
        Pattern pattern;
        Matcher matcher;
        Map<Long, ArrayList<Long>> seedMap = new HashMap<>();
        ArrayList<Long> seeds = new ArrayList<>();
        ArrayList<ArrayList<Long>> currentMapInfo = new ArrayList<>();
        int mapcount = 1;
        pattern = Pattern.compile(regex);
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath)) ){
            while((line = reader.readLine()) != null){
                matcher = pattern.matcher(line);
                if(isFirstLine){
                    while(matcher.find()){
                         seeds.add(Long.parseLong(matcher.group(1)));
                    }
                    for(Long seed : seeds){
                        seedMap.put(seed, new ArrayList<Long>());
                    }
                    isFirstLine = false;
                    continue;
                }

                if(line.contains(":"))
                    continue;

                if(line.trim().isEmpty()){
                    for( ArrayList<Long> set : currentMapInfo){
                        for(Map.Entry<Long, ArrayList<Long>> entry : seedMap.entrySet()){
                            try{
                                //going to add logic to see if the current entry or seed is greater than set[1] and less than set[1] + set[2]
                            }catch(IndexOutOfBoundsException e ){}
                        }
                    }
                    for(Map.Entry<Long, ArrayList<Long>> entry : seedMap.entrySet()){
                        Long entrySeed = entry.getKey();
                        ArrayList<Long> entrySeedArray = entry.getValue();
                        if(entrySeedArray.size() < mapcount){
                            if(mapcount == 1){
                                entrySeedArray.add(entrySeed);
                            }else{
                                entrySeedArray.add(entrySeedArray.get(mapcount-1));
                            }
                        }
                        entry.setValue(entrySeedArray);
                    }
                    currentMapInfo = new ArrayList<>();
                    mapcount++;
                    continue;
                }

                ArrayList<Long> numSet = new ArrayList<Long>();
                while(matcher.find()){
                    numSet.add(Long.parseLong(matcher.group(1)));
                }
               currentMapInfo.add(numSet);
            }
        }
    }
    public static void part2() throws FileNotFoundException, IOException{

    }

}
