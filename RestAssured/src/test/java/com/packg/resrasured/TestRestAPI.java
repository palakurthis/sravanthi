package com.packg.resrasured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

public class TestRestAPI {

	@Test
	public void TestApi() {
		given().
		when().
		get("http://ergast.com/api/f1/2008.json").
		then().
		assertThat().
		statusCode(200).
		and().
		statusLine("Success");
			}
}
