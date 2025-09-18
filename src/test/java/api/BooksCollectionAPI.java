package api;

import static io.restassured.RestAssured.given;

import base.BaseTest;
import io.restassured.response.Response;

public class BooksCollectionAPI extends BaseTest {

    public BooksCollectionAPI(){
    }

    public Response addBooksToCollection(String requestBody){
        Response response = given()
            .baseUri(baseURI)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + token)
            .body(requestBody)
            .pathParam("path", "Books")
            .log().all()
        .when()
            .post("{path}");
        return response;
    }

    public Response deleteBooksFromCollection(String requestBody){
         Response response = given()
            .baseUri(baseURI)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer " + token)
            .pathParam("path", "Books")
            .queryParam("UserId", "0da7426c-da11-4228-9693-28831e0834b1")
            .log().all()
        .when()
            .delete("{path}");
        System.out.println("Response dari Delete Books from Collection" + response.asPrettyString() + requestBody);
        return response;
    }
}
