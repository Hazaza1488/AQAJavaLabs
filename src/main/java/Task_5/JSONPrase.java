package Task_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONParse {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setId(123);
        user.setName("Yurii");
        user.setHobbies(Arrays.asList("apple", "banana", "orange"));

        System.out.println(user);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringJSON = objectMapper.writeValueAsString(user);
        System.out.println("stringJSON: " + stringJSON);

        User inputJsonUser = objectMapper.readValue(new File("input.json"), User.class);
        System.out.println("inputJsonUser: " + inputJsonUser);

        List<String> hobbies = inputJsonUser.getHobbies();
        hobbies.add("riding");
        objectMapper.writeValue(new File("output.json"), inputJsonUser);
        System.out.println("updated inputJsonUser: " + inputJsonUser);
    }
}
