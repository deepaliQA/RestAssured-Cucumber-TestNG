package utils;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthUtils {

    private static String accessToken;

    public static String getAccessToken() {

        if (accessToken == null) {
            generateToken();
        }

        return accessToken;
    }

    private static void generateToken() {

        Map<String, String> credentials = new HashMap<>();

        credentials.put(
            "username",
            ConfigReader.getProperty("auth.username")
        );

        credentials.put(
            "password",
            ConfigReader.getProperty("auth.password")
        );

        Response response =
            given()
                .baseUri(
                    ConfigReader.getProperty("baseUrl")
                )
                .header("Content-Type", "application/json")
                .body(credentials)
            .when()
                .post(
                    ConfigReader.getProperty("loginEndpoint")
                );

        response.then().statusCode(200);

        accessToken = response.jsonPath()
                .getString("accessToken");

        if (accessToken == null || accessToken.isEmpty()) {
            throw new RuntimeException(
                "Authentication failed: Access token not received"
            );
        }

        System.out.println("Authentication successful!");
    }
}