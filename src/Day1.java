import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Part 1:");
        part1();
        System.out.println("Part 2:");
        part2();

    }


    public static void part1() throws FileNotFoundException, IOException {
        String filepath = "./input/InputDay1";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int sum = 0;
            String regex = "\\d";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            StringBuilder concatenatedDigits;
            Integer number;
            while ((line = reader.readLine()) != null) {
                concatenatedDigits = new StringBuilder();
                String numberString = "";
                ArrayList<String> tempList = new ArrayList<>();
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String match = matcher.group();
                    tempList.add(match);
                }
                concatenatedDigits.append(tempList.get(0)).append(tempList.get(tempList.size() - 1));
                number = Integer.parseInt(concatenatedDigits.toString());
                sum = sum + number;
            }

            System.out.println(sum);
        }

    }

    public static void part2() throws FileNotFoundException, IOException {
        String filepath = "./input/InputDay1";
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            int sum = 0;
            String regex = "(?=(\\d|one|two|three|four|five|six|seven|eight|nine))";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            StringBuilder concatenatedDigits;
            Integer number;
            while ((line = reader.readLine()) != null) {
                concatenatedDigits = new StringBuilder();
                String numberString = "";
                ArrayList<String> tempList = new ArrayList<>();
                matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String match = matcher.group(1);
                    if(match.matches("\\d")) {
                        tempList.add(match);
                    }else{
                        tempList.add(parseNumber(match));
                    }

                }
                concatenatedDigits.append(tempList.get(0)).append(tempList.get(tempList.size() - 1));
                number = Integer.parseInt(concatenatedDigits.toString());
                sum = sum + number;
            }

            System.out.println(sum);
        }

    }

    private static String parseNumber(String str) {
        switch (str.toLowerCase()) {
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
            default:
                throw new NumberFormatException("Unknown number: " + str);
        }

    }
}