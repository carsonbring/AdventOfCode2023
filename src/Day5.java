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
        Boolean isSecondLine = true;
        Boolean noSeedMap = true;
        String regex = "\\b(\\d+)\\b";
        Pattern pattern;
        Matcher matcher;
        Map<Long, ArrayList<Long>> seedMap = new HashMap<>();
        ArrayList<Long> seeds = new ArrayList<>();
        ArrayList<ArrayList<Long>> currentMapInfo = new ArrayList<>();
        int mapcount = 1;
        pattern = Pattern.compile(regex);

        long min = Long.MAX_VALUE;
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
                    if(isSecondLine){
                        isSecondLine = false;
                        continue;
                    }

                    for(Map.Entry<Long, ArrayList<Long>> entry : seedMap.entrySet()){
                        Long entrySeed = entry.getKey();
                        ArrayList<Long> entrySeedArray = entry.getValue();


                        noSeedMap = true;


                        try {
                            for (ArrayList<Long> set : currentMapInfo) {

                                if(mapcount > 1){
                                    if(entrySeedArray.get(mapcount -2) >= set.get(1) &&
                                            entrySeedArray.get(mapcount -2) <= set.get(1) + set.get(2)){
                                            long displacement = entrySeedArray.get(mapcount -2) - set.get(1);
                                            entrySeedArray.add(set.get(0) + displacement);
                                            noSeedMap = false;

                                    }
                                }else{
                                    if(entrySeed >= set.get(1) && entrySeed <= set.get(1) + set.get(2)){
                                        Long dest = set.get(0);
                                        Long source = set.get(1);
                                        Long increment= set.get(2);
                                        long displacement = entrySeed - set.get(1);
                                        entrySeedArray.add(set.get(0) + displacement);
                                        noSeedMap = false;
                                    }
                                }
                            }
                        }catch(IndexOutOfBoundsException e) {}
                        if(noSeedMap){
                            if (mapcount == 1) {
                                entrySeedArray.add(entrySeed);
                            }else{
                                entrySeedArray.add(entrySeedArray.get(mapcount -2));
                            }

                        }
                        entry.setValue(entrySeedArray);
                    }
                    currentMapInfo = new ArrayList<>();
                    mapcount++;
                    continue;
                }
                //adding the info to the current map : base scenario
                ArrayList<Long> numSet = new ArrayList<Long>();
                while(matcher.find()){
                    numSet.add(Long.parseLong(matcher.group(1)));
                }
               currentMapInfo.add(numSet);
            }
            for(Map.Entry<Long, ArrayList<Long>> entry : seedMap.entrySet()){
                Long entrySeed = entry.getKey();
                ArrayList<Long> entrySeedArray = entry.getValue();


                noSeedMap = true;


                try {
                    for (ArrayList<Long> set : currentMapInfo) {

                        if(mapcount > 1){
                            if(entrySeedArray.get(mapcount -2) >= set.get(1) &&
                                    entrySeedArray.get(mapcount -2) <= set.get(1) + set.get(2)){
                                long displacement = entrySeedArray.get(mapcount -2) - set.get(1);
                                entrySeedArray.add(set.get(0) + displacement);
                                noSeedMap = false;

                            }
                        }else{
                            if(entrySeed >= set.get(1) && entrySeed <= set.get(1) + set.get(2)){
                                Long dest = set.get(0);
                                Long source = set.get(1);
                                Long increment= set.get(2);
                                long displacement = entrySeed - set.get(1);
                                entrySeedArray.add(set.get(0) + displacement);
                                noSeedMap = false;
                            }
                        }
                    }
                }catch(IndexOutOfBoundsException e) {}
                if(noSeedMap){
                    if (mapcount == 1) {
                        entrySeedArray.add(entrySeed);
                    }else{
                        entrySeedArray.add(entrySeedArray.get(mapcount -2));
                    }

                }
                entry.setValue(entrySeedArray);
            }
            ArrayList<Long> minSeedArray = new ArrayList<>();
            Long minSeed = 0L;
            for(Map.Entry<Long, ArrayList<Long>> entry : seedMap.entrySet()){
                if( entry.getValue().getLast() < min){
                    min = entry.getValue().getLast();
                    minSeedArray = entry.getValue();
                    minSeed = entry.getKey();
                }
            }
            System.out.println(min);



        }
    }
    public static void part2() throws FileNotFoundException, IOException{

    }

}
