package stepDefinitions;

	import base.TestBase;

	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	import org.testng.Assert;

	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
	import io.cucumber.java.en.Then;

	import static io.restassured.RestAssured.given;

	public class CommonSteps {

	    RequestSpecification request;
	    Response response;
	    String endpoint;


	    @Given("the API endpoint is {string}")
	    public void the_api_endpoint_is(String endpoint) {
	    	this.endpoint = endpoint;

	        request = given()
	                .spec(TestBase.getRequestSpecification());

	        System.out.println("Endpoint: " + endpoint);
	    }

	    @When("I send a GET request")
	    public void i_send_a_get_request() {

	        response = request
	                .when()
	                .get(endpoint);

	        response.prettyPrint();
	    }

	    @Then("the response status code should be {int}")
	    public void validate_status_code(int statusCode) {

	        Assert.assertEquals(
	                response.getStatusCode(),
	                statusCode
	        );
	    }

	    @Then("the response should contain first name {string}")
	    public void validate_first_name(String firstName) {

	        String actualName = response.jsonPath()
	                .getString("firstName");

	        Assert.assertEquals(actualName, firstName);
	    }
	}


