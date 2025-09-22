package apiengine;

import static io.restassured.RestAssured.given;

import api.example.model.request.RequestAddBooks;
import io.restassured.response.Response;

public class BooksCollectionAPI{ 

    public static <T> Response addBooksToCollectionAPI(T payload){ 
        return  given()
                .body(payload).log().all()
                .when()
                    .post("/Books");
    }

    public static <T> Response deleteSingleBookFromCollectionAPI(T payload){    
        return  given()
                .body(payload).log().all()
                .when()
                    .delete("/Book");
    }

    public static Response deleteBooksFromCollectionAPI(String userId){    
        Response response = given()
                                .queryParam("UserId", userId)
                                .log().all()
                            .when() 
                                .delete("/Books");
        return response;
    }
}
