package restsssuredTests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.RestAssured;


public class Demo4_MultipleVal_Validation {
	@Test
	public void Multiple_Val_Validation()
	{
		given()
		
			.when()
				.get("https://api.restful-api.dev/objects")
			.then()
			.body("name",hasItem("Apple iPad Air"))
			.body("name",hasItems("Google Pixel 6 Pro","Apple AirPods","Apple iPad Air"));
			
	}

	@Test
	public void CallwithQueryParameters()
	{
		given()
			.param("id",13)
			.headers("Content-Type","application/json")
		
			.when()
				.get("https://api.restful-api.dev/objects")
			.then()
			.body("name",hasItem("Apple iPad Air"));			
	}
}
