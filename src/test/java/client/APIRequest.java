
package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class APIRequest {

    private final RequestSpecification requestSpec;

    // Constructor
    public APIRequest(RequestSpecification requestSpec) {
        this.requestSpec = requestSpec;
    }

    // GET request
    public Response get(String endpoint) {

        return given()
                .spec(requestSpec)
                .when()
                .get(endpoint);
    }

    // POST request
    public Response post(String endpoint, Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    // PUT request
    public Response put(String endpoint, Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .put(endpoint);
    }

    // PATCH request
    public Response patch(String endpoint, Object requestBody) {

        return given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .patch(endpoint);
    }

    // DELETE request
    public Response delete(String endpoint) {

        return given()
                .spec(requestSpec)
                .when()
                .delete(endpoint);
    }

    // Generic method to execute all HTTP methods
    public Response execute(
            String method,
            String endpoint,
            Object requestBody) {

        switch (method.toUpperCase()) {

            case "GET":
                return get(endpoint);

            case "POST":
                return post(endpoint, requestBody);

            case "PUT":
                return put(endpoint, requestBody);

            case "PATCH":
                return patch(endpoint, requestBody);

            case "DELETE":
                return delete(endpoint);

            default:
                throw new IllegalArgumentException(
                    "Unsupported HTTP method: " + method
                );
        }
    }

 // Deserialize response into Java POJO
    public <T> T getResponseAs(
            Response response,
            Class<T> responseClass) {

        return response.as(responseClass);
    }
}
