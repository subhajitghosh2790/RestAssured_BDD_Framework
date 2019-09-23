package restassuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * 1. Verify Single content
 * 2. Verify multiple content
 * 3. Verify all contents in one go --> text() method
 * 4. using hasXPATH method (2 different ways) 
 * */

public class Demo6_BASIC_VALIDATION_XML_Format {

	@Test(priority =1)
	void testSingleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
	}

	
	@Test(priority =2)
	void testMultipleContent() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.and()
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
			.and()
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.log().all();
	}
	
	
	@Test(priority =3)
	void testAllContentsInOneGo() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle"))
			
			.log().all();
	}
	
	@Test(priority =4)
	void testUsingXPATH1() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("/CUSTOMER/ID", containsString("15")))
			
			.log().all();
	}
	
	@Test(priority =5)
	void testUsingXPATH2() {
		
		given()
		.when()
			.get("http://thomas-bayer.com/sqlrest/INVOICE/")
		.then()
			.body(hasXPath("/INVOICEList/INVOICE[text()= '30']"))
			
			.log().all();
	}
}
