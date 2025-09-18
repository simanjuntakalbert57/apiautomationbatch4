package utils;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class TokenManager {
    private static String token;

    public static String getToken() {
        if (token == null) {
            token = generateToken();
        }
        return token;
    }

    public static String generateToken() {
        // Logic to generate a new token, e.g., make an API call to get a token
        // For demonstration, we'll just return a dummy token
        String requestBody = "{\n" + //
                        "  \"userName\": \""+Helper.get("USERNAME")+"\",\n" + //
                        "  \"password\": \""+Helper.get("PASSWORD")+"\"\n" + //
                        "}";
        Response response = 
                given()
                    .baseUri("https://demoqa.com/Account/v1/GenerateToken")
                    .header("Content-Type", "application/json")
                    .header("accept", "application/json")
                    .body(requestBody)
                .when()
                    .post();
        System.out.println("Response: " + response.asString());
        token = response.jsonPath().getString("token");
        
        return token;
    }

}
