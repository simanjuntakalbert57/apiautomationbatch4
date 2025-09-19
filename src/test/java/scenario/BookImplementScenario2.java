package scenario;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.example.base.BaseTest;
import apiengine.BooksCollectionAPI;
import io.restassured.response.Response;

public class BookImplementScenario2 extends BaseTest  {
    public String token;
    public BooksCollectionAPI booksCollectionAPI;

    @Test()
    public void add_books_to_collection(){
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
        Assert.assertTrue(response.jsonPath().getString("books[0].isbn").equals("9781593277574"), "ISBN should be 9781593277574");
    }

    @Test(dependsOnMethods = {"add_books_to_collection"})
    public void delete_books_from_collection(){
        System.out.println("Delete Books from Collection");
        String userId = "0da7426c-da11-4228-9693-28831e0834b1";
        Response response = BooksCollectionAPI.deleteBooksFromCollectionAPI(userId);
        Assert.assertEquals(response.statusCode(), 204, "Status code should be 204");
    }
}
