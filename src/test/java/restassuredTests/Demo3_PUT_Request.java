package restassuredTests;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import utility.RestUtils;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo3_PUT_Request {

	public static HashMap hm = new HashMap();
	int emp_id = 51465;

	@BeforeClass
	void putData() {

		hm.put("name", RestUtils.empName());
		hm.put("salary", RestUtils.empSal());
		hm.put("age", RestUtils.empAge());

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		//RestAssured.basePath = "/update" + emp_id;
	}

	@Test
	void testPUT() {
		
		given()
			.contentType("application/json")
			.body(hm)
		.when()
			.put("/update"+emp_id)
		.then()
			.log().all();
	}
}
