package convert_data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.example.model.RequestAddBooks;

public class ConvertData {
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
        String requestBody = "{\n" + //
                "  \"userId\": \"f47ac10b-58cc-4372-a567-0e02b2c3d479\",\n" + //
                "  \"collectionOfIsbns\": [\n" + //
                "    {\n" + //
                "      \"isbn\": \"9781593277574\"\n" + //
                "    },\n" + //
                "    {\n" + //
                "      \"isbn\": \"9781449331818\"\n" + //
                "    }\n" + //
                "  ]\n" + //
                "}";
        
        // System.out.println(requestBody);
        ObjectMapper objectMapper = new ObjectMapper();
        RequestAddBooks requestAddBooks = objectMapper.readValue(requestBody, RequestAddBooks.class);
        System.out.println("-------- Convert Json to Object ---------");
        System.out.println(requestAddBooks.userId);
        System.out.println(requestAddBooks.collectionOfIsbns[0].isbn);
        System.out.println(requestAddBooks.collectionOfIsbns[1].isbn);
    }

}
