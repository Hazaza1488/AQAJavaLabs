package Task_5;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class XmlPrase {

    public static  void main(String[] args) throws IOException {
        User user = new User();
        user.setId(123);
        user.setName("Yuri");
        user.setHobbies(asList("reading", "hiking", "cooking"));

        System.out.println(user);


        XmlMapper xmlMapper =new XmlMapper();
        String stringXML=xmlMapper.writeValueAsString(user);
        System.out.println("stringXML: "+stringXML);

        User inputXmlUser=xmlMapper.readValue(new File("input.xml"),User.class);
        System.out.println("inputXmlUser: "+inputXmlUser);

        inputXmlUser.getHobbies().add("riding");
        xmlMapper.writeValue(new File("output.xml"),inputXmlUser);
        System.out.println("updated inputXmlUser: "+inputXmlUser);
    }
}
