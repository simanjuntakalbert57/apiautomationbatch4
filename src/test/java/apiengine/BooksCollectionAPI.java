package apiengine;

import static io.restassured.RestAssured.given;


import io.restassured.response.Response;

public class BooksCollectionAPI{ 

    public static Response addBooksToCollectionAPI(String requestBody){ 
        return  given()
                .body(requestBody).log().all()
                .when()
                    .post("/Books");
    }

    public static Response deleteSingleBookFromCollectionAPI(String requestBody){    
        return  given()
                .body(requestBody).log().all()
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
