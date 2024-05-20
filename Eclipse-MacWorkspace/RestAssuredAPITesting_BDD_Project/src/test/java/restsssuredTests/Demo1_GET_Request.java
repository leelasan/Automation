package restsssuredTests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Demo1_GET_Request {
	
	// unless you specify the annotation @Test, testng will not execute that method.
	// to use testng annotations, we need to import the corresponding package org.testng.annotations.Test
	
	@Test
	public void getBarddetails()
	{
		
		// To use given, when and then sections, we need to import a static package io.restassured.RestAssured.*
		// the first section will not get . (dot) 
		// the last section will end with semicolon after all the statements. 
		//No semicolon for any statements or sections prior to that
		
		// as we don't have any prerequisite for this GET request, we are not adding any statement to this section
		given()		

		// use double quotes while providing the value in the get request 
		 .when()
		 	.get("https://api.github.com/users/Bard")
		.then()
			.statusCode(200)
			
			//for body stuff to validate we use equalTo
			.assertThat().body("name",equalTo("Massimiliano Mirra"))
			
			//for header data validation, we don't need equalTo
			.header("Content-Type","application/json; charset=utf-8");	
	}

}
