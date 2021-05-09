import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExampleOne {
    public static void main(String[] args) {

        File file = new File("src/resources/file.txt");
        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exsist");
        }
        List<String> list = new ArrayList<String>();
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);
            String line = reader.readLine();
            while (line != null) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.print("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern p = Pattern.compile("\\d\\d\\d[-]\\d\\d\\d[-]\\d\\d\\d\\d");
        Pattern p2 = Pattern.compile("[(]\\d\\d\\d[)]\\s\\d\\d\\d[-]\\d\\d\\d\\d");
        for(String s : list){
            Matcher m = p.matcher(s);
            Matcher m2 = p2.matcher(s);
            if(m.matches()){
                System.out.println(s);
            }
            else if(m2.matches()){
                System.out.println(s);
            }
        }

    }
}
