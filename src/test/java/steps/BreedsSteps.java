package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BreedsSteps {
	
	private RequestSpecification request;
    private Response response;
    private String baseUrl;
	
	@Given("I set the base API URL")
    public void setBaseApiUrl() {
        baseUrl = "https://jsonplaceholder.typicode.com";
        request = given().baseUri(baseUrl);
    }

    @Given("I set the request body:")
    public void setRequestBody(String requestBody) {
        request.body(requestBody);
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = request.get(endpoint);
    }

    @When("I send a POST request to {string}")
    public void sendPostRequest(String endpoint) {
        response = request.post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {string} with value {string}")
    public void verifyResponseBody(String key, String value) {
        response.then().body(key, equalTo(value));
    }
}
