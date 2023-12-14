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
        boolean[][] visited = new boolean[engine.length][engine[0].length];
        int sum = 0;
        for(int i = 0; i < engine.length; i++){
            for(int j = 0; j < engine.length; j++){
                if(Character.isDigit(engine[i][j])){
                    if(isSpecialAdjacent(engine, i, j)){
                        try {
                            String capturedNum = captureNumber(engine, visited, i, j);
                            sum = sum + Integer.parseInt(capturedNum);
                        }catch(NumberFormatException e){}
                    }
                }
            }
        }
        System.out.println(sum);
    }
    public static void part2(char[][] engine) throws FileNotFoundException, IOException{

    }
    private static boolean isSpecialCharacter(char ch) {
        String specialCharacters = "!@#$%^&*()-=_+[]{}|;:'\\,<>?/";
        return specialCharacters.contains(String.valueOf(ch));
    }

    private static String captureNumber(char[][] engine, boolean[][] visited, int i, int j) {
        //Checking to see if the current cell is out of bounds, already visited, or not a digit
        if (i < 0 || i >= engine.length || j < 0 || j >= engine[0].length || visited[i][j] || !Character.isDigit(engine[i][j])) {
            return "";
        }
        visited[i][j] = true;
        char currentDigit = engine[i][j];
        return captureNumber(engine, visited, i, j - 1) +
                currentDigit +
                captureNumber(engine, visited, i, j + 1);
    }

    private static boolean isSpecialAdjacent(char[][] engine, int i, int j) {
        int rows = engine.length;
        int cols = engine[0].length;
        //for loop that checks for boundaries by using min and max functions
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, rows - 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, cols - 1); y++) {
                if (x != i || y != j) {
                    if (isSpecialCharacter(engine[x][y])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
