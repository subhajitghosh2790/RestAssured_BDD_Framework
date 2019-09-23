package restassuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.*;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo4_DELETE_Request {

	@BeforeTest
	public void deleteData() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//RestAssured.basePath = "";
	}
	
	@Test
	public void DeleteTest1() {
		
		
		
		Response response = 
				given()
		.when()
			.delete("/delete/11493")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonPath = response.asString();
		
		Assert.assertTrue(jsonPath.contains("successfully! deleted Records"));	
	}
	
	
}
