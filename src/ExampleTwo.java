import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ExampleTwo {
    public static void main(String[] args) throws IOException {
        File file = new File("src/resources/file1.txt");
        if(!file.exists()){
            throw new RuntimeException("File with name " + file.getName() + " not exsist");
        }
        StringBuilder sb = new StringBuilder();

        List<User> list = new ArrayList<>();


        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            while (sc.hasNext()) {
                String s = sc.nextLine();
                list.add(saveUser(s));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        list.remove(0);




        /*
        Path path = Paths.get("src/resources/file1.txt");
        List<String> strings = Files.readAllLines(path);
        String[] alice = strings.get(1).split(" ");
        String[] ryan = strings.get(2).split(" ");


        User[] users= {new User(alice[0], alice[1]), new User(ryan[0], ryan[1])};

         */


        Gson gson = new Gson();


        String result = gson.toJson(list);
        Files.write(Paths.get("src/resources/user.json"), Collections.singleton(result));


    }

    public static User saveUser(String s){
        String[] result = s.split(" ");
        User user = new User(result[0], result[1]);
        return user;
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
