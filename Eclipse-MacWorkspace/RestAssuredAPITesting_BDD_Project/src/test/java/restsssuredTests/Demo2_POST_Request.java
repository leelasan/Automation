package restsssuredTests;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class Demo2_POST_Request {
	
	//declared to get the return value of a POST request to use in DELETE request
	String id;
	
	// create request body using HashMap
	// here I used methods to generate data runtime. also, you can pass the data here directly
	//public static HashMap<String, Object> data = new HashMap<String, Object>();
	//@BeforeClass
	public void postDatausingHashMap()
	{
		data.put("name",Demo2_RestUtils.getName());
		Object dataArr[] = {Demo2_RestUtils.getYear(), Demo2_RestUtils.getPrice(), Demo2_RestUtils.getModel(), Demo2_RestUtils.getSize()};
		data.put("data",dataArr);		
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";	
	}
	
	// create request body using org.json object library
	// here I used methods to generate data runtime. also, you can pass the data here directly
	// Not much difference with HashMap and JSONObject except using toString() when used JSONObject while in .body
	public static JSONObject data = new JSONObject();
	//@BeforeClass
	public void postDatausingjsonlibrary()
	{
		data.put("name",Demo2_RestUtils.getName());
		Object dataArr[] = {Demo2_RestUtils.getYear(), Demo2_RestUtils.getPrice(), Demo2_RestUtils.getModel(), Demo2_RestUtils.getSize()};
		data.put("data",dataArr);		
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";	
	}
	
	// create request body using POJO (plain old java object)
	//@BeforeClass
	public void postDatausingPOJO()
	{
		Demo2_POJO_Class data = new Demo2_POJO_Class();
		data.setName("Apple MacBook Pro 16");
		Object dataArr[] = {2019,1849.99,"Intel Core i9","1 TB"};
		data.setData(dataArr);		
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";	
	}
	
	// create request body using an external json file
	@BeforeClass
	public void postDatausingExternalJSONfile() throws FileNotFoundException
	{
		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";
	}
	
	// use this when you want to validate the data in the then section without return
	//@Test (priority=1)
	//and() in the Then section is optional
	public void testPostwithThenSection()
	{
		given()
			.contentType("application/json")
			.body(data)
			
			.when()
				.post()
				
			.then()
				.statusCode(200)
				.and()
				.statusLine("HTTP/1.1 200 ")
				.and()
				.headers("Content-Type","application/json")
				.and()
				.log().all();
	}
	
	//use this method when you want to capture the id as return value to a variable to delete the record after you create.
	//use this method when you are using HashMap object to send the body record
	//use this method when you are using POJO to send the body record	
	//@Test (priority=1)
	public void testPostwithHashMaporPOJO()
	{
		id=given()
			.contentType("application/json")
			.body(data)
			
			.when()
				.post()
				.jsonPath().getString("id");
				
	}
	
	//use this method when you use json object library to send the body record
	//use this method when you use JSONObject i.e. external JSON file to send the body record
	@Test (priority=1)
	public void testPostwithjsonobject()
	{
		id=given()
				.contentType("application/json")
				.body(data.toString())
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