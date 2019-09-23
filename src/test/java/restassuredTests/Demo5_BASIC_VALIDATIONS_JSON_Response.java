package restassuredTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


/*
 * 
1. Test Status Code
2. Log Response
3. Verifying Single content in response body
4. verifying multiple content in response body
5. setting parameters and body
*/
  

public class Demo5_BASIC_VALIDATIONS_JSON_Response {

	
	  // 1. Test Status Code
	  
	  @Test(priority = 1) public void testStatusCode() {
	  
	  given().when().get("http://jsonplaceholder.typicode.com/posts/5").then().
	  statusCode(200);
	  
	  }
	  
	  // 2. Log Response
	  
	  @Test(priority = 2) public void testLogging() {
	  
	  given().when().get("http://api.worldbank.org/v2/country/ABW?format=json").
	  then().statusCode(200).log().all(); }
	  
	  // 3. Verifying Single content in response body // here first use postman to
	  //send url and get the body and then // create json path in the body method to
	  //verify the content in the JSON
	  
	  @Test(priority =3) public void testSingleContent() {
	  
	  given() .when() .get("http://api.worldbank.org/v2/country/ABW?format=json")
	  .then() .statusCode(200) .body("[1][0].region.id", equalTo("LCN")); 
	  
	  
	  // here use plugin 'JSONPath Finder' to get the value of the node // or we can write
	  //our own JSONPath, but for complex ones use plugin 
	  
	  }
	 
	@Test(priority=4)
	public void testMultipleContent() {
		
		given()
		.when()
			.get("https://restcountries.eu/rest/v2/all")
		.then()
			.statusCode(200)
			.body("[0].name", is("Afghanistan"));
		
		// watch this video as the 'body()' method i have used is wrong
		//https://www.youtube.com/watch?v=OSnvd8sMpGQ&list=PLUDwpEzHYYLskkglxoXd0L6DKu4uOfh-m&index=6
	}
	
	
	//5. setting parameters and body
	@Test(priority=5)
	public void testParamsAndHeaders() {
		
		given()
			.param("My Paramater KEY", "My Parameter VALUE")
			.header("Subhajit", "Ghosh")
		.when()
			.get("https://restcountries.eu/rest/v2/all")
		.then()
			.statusCode(200)
			.log().all();
	
	}
}
