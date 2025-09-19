package api.example.utils;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class TokenManager {
    public static String token;

    public static String getToken() {
        if (token == null) {
            token = generateToken();
            
        }
        return token;
    }
    
    public static String generateToken(){
        System.out.println("Generate Token");
        String requestBody = "{\n" + //
                        "  \"userName\": \"afteroffice2@gmail.com\",\n" + //
                        "  \"password\": \"AfterOffice@123\"\n" + //
                        "}";
        Response response = 
                given()
                    .baseUri("https://demoqa.com/Account/v1/GenerateToken")
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(requestBody)
                .when()
                    .post();
        token = response.jsonPath().getString("token");

        return token;
    }
}
