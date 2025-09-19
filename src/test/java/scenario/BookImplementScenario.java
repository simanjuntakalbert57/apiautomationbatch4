package scenario;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.example.base.BaseTest;
import api.example.model.ResponseAddBooks;
import apiengine.BooksCollectionAPI;
import io.restassured.response.Response;

public class BookImplementScenario extends BaseTest  {
    public String token;
    public BooksCollectionAPI booksCollectionAPI;

    @Test()
    public void add_books_to_collection() throws JsonMappingException, JsonProcessingException{
        System.out.println("Add Books to Collection");
        String requestBody = "{\n" + //
                        "  \"userId\": \"0da7426c-da11-4228-9693-28831e0834b1\",\n" + //
                        "  \"collectionOfIsbns\": [\n" + //
                        "    {\n" + //
                        "      \"isbn\": \"9781593277574\"\n" + //
                        "    }\n" + //
                        "  ]\n" + //
                        "}";

        Response response = BooksCollectionAPI.addBooksToCollectionAPI(requestBody);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 201, "Status code should be 200");
        // Assert.assertTrue(response.jsonPath().getString("books[0].isbn").equals("9781593277574"), "ISBN should be 9781593277574");
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseAddBooks responseAddBooks = objectMapper.readValue(response.asString(), ResponseAddBooks.class);

        System.out.println("-------- Convert Json to Object ---------");
        System.out.println(responseAddBooks.isbn[0].isbn);
        Assert.assertTrue(responseAddBooks.isbn[0].isbn.equals("9781593277574"), "ISBN should be 9781593277574");
    }

    @Test()
    public void delete_book_byId_from_collection3(){
        System.out.println("Delete Books from Collection");
        String requestBody = "{\n" + //
                        "  \"isbn\": \"9781593277574\",\n" + //
                        "  \"userId\": \"0da7426c-da11-4228-9693-28831e0834b1\"\n" + //
                        "}";
        Response response = BooksCollectionAPI.deleteSingleBookFromCollectionAPI(requestBody);
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(), 204, "Status code should be 204");
    }
}
