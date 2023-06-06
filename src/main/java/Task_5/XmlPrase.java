package Task_5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class XmlParse {

    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setId(123);
        user.setName("Yurii");
        user.setHobbies(Arrays.asList("apple", "banana", "orange"));

        System.out.println(user);

        XmlMapper xmlMapper = new XmlMapper();
        String stringXML = xmlMapper.writeValueAsString(user);
        System.out.println("stringXML: " + stringXML);

        User inputXmlUser = xmlMapper.readValue(new File("input.xml"), User.class);
        System.out.println("inputXmlUser: " + inputXmlUser);

        List<String> hobbies = inputXmlUser.getHobbies();
        hobbies.add("riding");
        xmlMapper.writeValue(new File("output.xml"), inputXmlUser);
        System.out.println("updated inputXmlUser: " + inputXmlUser);
    }
}
