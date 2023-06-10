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
        user.setFruits(Arrays.asList("apple", "banana", "orange"));

        System.out.println(user);

        // Serialization to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String stringJSON = objectMapper.writeValueAsString(user);
        System.out.println("stringJSON: " + stringJSON);

        // Deserialization from JSON
        User inputJsonUser = objectMapper.readValue(new File("input.json"), User.class);
        System.out.println("inputJsonUser: " + inputJsonUser);

        List<String> fruits = inputJsonUser.getFruits();
        fruits.add("apple");

        // Serialization to JSON with updated data
        objectMapper.writeValue(new File("output.json"), inputJsonUser);
        System.out.println("updated inputJsonUser: " + inputJsonUser);

        // Serialization to XML
        XmlMapper xmlMapper = new XmlMapper();
        String stringXML = xmlMapper.writeValueAsString(user);
        System.out.println("stringXML: " + stringXML);

        // Deserialization from XML
        User inputXmlUser = xmlMapper.readValue(new File("input.xml"), User.class);
        System.out.println("inputXmlUser: " + inputXmlUser);

        List<String> xmlFruits = inputXmlUser.getFruits();
        xmlFruits.add("apple");

        // Serialization to XML with updated data
        xmlMapper.writeValue(new File("output.xml"), inputXmlUser);
        System.out.println("updated inputXmlUser: " + inputXmlUser);
    }
}
