import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExampleTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/deniscerep/Documents/GoIT/HomeWorkNine/src/file1.txt");
        /*if(!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " not exsist");
        }
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNext()) sb.append(sc.nextLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(sb);

         */

        Path path = Paths.get("/Users/deniscerep/Documents/GoIT/HomeWorkNine/src/file1.txt");
        List<String> strings = Files.readAllLines(path);
        String[] alice = strings.get(1).split(" ");
        String[] ryan = strings.get(2).split(" ");


        User[] users= {new User(alice[0], alice[1]), new User(ryan[0], ryan[1])};

        Gson gson = new Gson();

        String result = gson.toJson(users);
        Files.write(Paths.get("/Users/deniscerep/Documents/GoIT/HomeWorkNine/src/user.json"), Collections.singleton(result));


    }
}

class User {
    private String name;
    private String age;

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
