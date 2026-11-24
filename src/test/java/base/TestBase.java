package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.AuthUtils;
import utils.ConfigReader;

public class TestBase {
	//public API request
	 public static RequestSpecification getRequestSpecification() {

	        return new RequestSpecBuilder()
	                .setBaseUri(ConfigReader.getProperty("baseUrl"))
	                .addHeader("Accept", "application/json")
	                .addHeader("Content-Type", "application/json")
	                .build();
	    }
	 // Authenticated API request
	    public static RequestSpecification getAuthenticatedRequestSpecification() {

	        return new RequestSpecBuilder()
	                .setBaseUri(ConfigReader.getProperty("baseUrl"))
	                .addHeader("Accept", "application/json")
	                .addHeader("Content-Type", "application/json")
	                .addHeader("Authorization","Bearer " + AuthUtils.getAccessToken())
	                .build();
	    }
}
