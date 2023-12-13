import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {


    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filepath = "../input/InputDay1";
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))){
            String line;
            int sum;
            String regex= "\\d+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            while((line = reader.readLine()) != null){
                    number
                   matcher = pattern.matcher(line);
                   while(matcher.find()){
                       String match = matcher.group();



                   }
            }
        }

    }
}