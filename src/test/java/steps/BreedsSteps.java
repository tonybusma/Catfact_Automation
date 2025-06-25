package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;

public class BreedsSteps {
	
	private String baseUrl; 
    private Response response;
	
	@Given("that the user queries the GET endpoint")
    public void setBaseUrl() {
		baseUrl = "https://catfact.ninja/breeds";       
    }

    @When("enters the value {int} in the limit field and executes the request")
    public void setIntegerParamAndGetResponse(int value) {
    	response = given().queryParam("limit", value).when().get(baseUrl);
    }
    
    @When("enters the value {string} in the limit field and executes the request")
    public void setStringParamAndGetResponse(String value) {
    	response = given().queryParam("limit", value).when().get(baseUrl);
    }
    
    @When("enters the value {int} in the limit field, {int} in the page field and executes the request")
    public void setParamsAndGetResponse(int limit, int page) {
    	response = given()
    			.queryParam("limit", limit)
    			.queryParam("page", page)
    			.when().get(baseUrl);
    }

    @Then("the endpoint should return status code {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("should return a list with the number of items equal to {int}")
    public void checkDataSizeInBody(int value) {
    	response.then().body("data", hasSize(value));
    }
    
    @And("should return the message {string}")
    public void checkMessageBody(String message) {
    	response.then().body("message", is(message));
    }
    
    @And("should return the value {int} in the {string} field")
    public void checkDataFieldsInBody(int value, String field) {
    	response.then().body(field, is(value));
    }
    
    @And("should return the empty data list")
    public void checkDataFieldEmpty() {
    	response.then().body("data", is(Arrays.asList()));
    }
}
