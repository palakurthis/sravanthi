package com.packg.resrasured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
//test from git to sel
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
