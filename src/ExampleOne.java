import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleOne {
    public static void main(String[] args) {

        File file = new File("/Users/deniscerep/Documents/GoIT/HomeWorkNine/src/file.txt");
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

        for(String s : list){
            if(s.contains("-")){
                System.out.println(s);
            }
        }

    }
}
