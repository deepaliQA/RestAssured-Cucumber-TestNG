package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.testng.Assert;

import base.TestBase;

public class AuthenticationsSteps {
	RequestSpecification request;
    Response response;
    
	@Given("I create an authenticated API request")
	public void i_create_an_authenticated_api_request() {
	    // Write code here that turns the phrase above into concrete actions
request =given().spec(TestBase.getAuthenticatedRequestSpecification());

}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String endpoint) {
response = request.when().get(endpoint);	
response.prettyPrint();
}

	@Then("the response should contain username {string}")
	public void the_response_should_contain_username(String username) {
	    // Write code here that turns the phrase above into concrete actions
		 	String actualUsername = response.jsonPath().getString("username");
	        Assert.assertEquals(actualUsername, username);

	}
	
	 @Then("the authenticated response status code should be {int}")
	    public void validate_status_code(int statusCode) {

	        Assert.assertEquals(
	                response.getStatusCode(),
	                statusCode
	        );
	    }



}
