package serializationAndDeserialization;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import restsssuredTests.Demo2_POJO_Class;
import restsssuredTests.Demo2_RestUtils;

public class POSTandDeleteWithoutSerialization {

	//Without serialization is just doing what we did till now...
		String id;
		public static HashMap<String, Object> data = new HashMap<String, Object>();

				
		@Test (priority=1)
		public void testPUT()
		{
			data.put("name","Apple MacBook Pro 16");
			ArrayList<Object> dataArr= new ArrayList<Object>();
			dataArr.add(2019);
			dataArr.add(1849.99);
			dataArr.add("Intel Core i9");
			dataArr.add("1 TB");
			data.put("data",dataArr);		
			RestAssured.baseURI = "https://api.restful-api.dev";
			RestAssured.basePath = "/objects";
			
			id=given()
				.contentType("application/json")
				.body(data)
				
				.when()
					.post()
					.jsonPath().getString("id");		
		}
	
		@Test(priority=2)
		public void testDelete()
		{
			System.out.println(id);
			given()
				.when()
					.delete("https://api.restful-api.dev/objects/"+id)
				.then()
				.log().all();
		}
}
