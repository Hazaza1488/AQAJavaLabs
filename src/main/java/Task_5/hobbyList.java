package Task_5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class hobbyList {
    public int id;
    public  String name;
    public ArrayList<String> hobbies;


    @Override
    public  String toString(){
        return  "id: " + id + "\nName: " + name + "\nHobbies: " + hobbies;
    }

    public static  void main(String[] args) throws IOException {
        //input
        File inputFile = new File("E:/Labs_AT/AT_TASKS/src/main/java/Task_5/input.json");
        FileInputStream input = new FileInputStream(inputFile);
        ObjectMapper objectMapper = new ObjectMapper();
        hobbyList k = objectMapper.readValue(input, hobbyList.class);

        k.id = 1;
        k.name = "Yuri";
        k.hobbies.set(0, "BMX");

        //output
        objectMapper.writeValue(new File("E:/Labs_AT/AT_TASKS/src/main/java/Task_5/output.json"), k);
        System.out.println(k);
    }
}
