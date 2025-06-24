package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {
	
	public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
            .setBaseUri("https://catfact.ninja/breeds")
            .setContentType(ContentType.JSON)
            .build();
    }
}
