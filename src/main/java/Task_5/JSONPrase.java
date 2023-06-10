package Task_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JSONParse {

    public static void main(String[] args) throws IOException {
//        General task for all:
//        Serialization-Deserialization:
//        a) Make some complex models using your variant.
//                b) Make it serializable.
//                c) Read json from “input.json”
//        d) and deserialize it to POJO.
//                e) Then change a few fields and save it to “output.json”.
//        f) Do the same for xml.

                User user = new User();
        user.setId(123);
        user.setName("Yurii");
        user.setFruits(Arrays.asList("apple", "banana", "orange"));

        System.out.println(user);

        ObjectMapper objectMapper = new ObjectMapper();
        String stringJSON = objectMapper.writeValueAsString(user);
        System.out.println("stringJSON: " + stringJSON);

        User inputJsonUser = objectMapper.readValue(new File("input.json"), User.class);
        System.out.println("inputJsonUser: " + inputJsonUser);

        List<String> fruits = inputJsonUser.getFruits();
        fruits.add("apple");
        objectMapper.writeValue(new File("output.json"), inputJsonUser);
        System.out.println("updated inputJsonUser: " + inputJsonUser);
    }
}
