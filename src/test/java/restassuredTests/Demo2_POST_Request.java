package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utility.RestUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo2_POST_Request {

	public HashMap hm = new HashMap();

	@BeforeClass
	public void postData() {

		hm.put("FirstName", RestUtils.getFirstName());
		hm.put("LastName", RestUtils.getLastName());
		hm.put("UserName", RestUtils.getUserName());
		hm.put("Password", RestUtils.getPassword());
		hm.put("Email", RestUtils.getEmail());

		RestAssured.baseURI = "https://restapi.demoqa.com/customer";

	}

	@Test
	public void testPost() {
		
		given()
		.body(hm)
			.contentType("application/json")
					
		.when()
			.post("/register")
		.then()
			.body("SuccessCode", equalTo("operation_success".toUpperCase()))
			.and()
			.body("Message", equalTo("Operation completed successfully"))
			.and()
			.statusCode(201);
	}

}
