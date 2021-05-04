import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class ExampleThree {
    public static void main(String[] args) {
        File file = new File("/Users/deniscerep/Documents/GoIT/HomeWorkNine/src/word.txt");
        if (!file.exists()) {
            throw new RuntimeException("File with name " + file.getName() + " not exsist");
        }
        StringBuilder alltext = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line!=null) {
                alltext.append(line+" ");
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = alltext.toString();
        String replace = text.replace("  ", " ");


        Map<String, Integer> result = countRepetitions(replace);

        result.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

    }


        public static Map<String, Integer> countRepetitions(String str) {
            return Arrays.stream(str.split(" "))
                    .collect(Collectors.toMap(s -> s, s -> 1, (a, b) -> a+1));
        }





}
