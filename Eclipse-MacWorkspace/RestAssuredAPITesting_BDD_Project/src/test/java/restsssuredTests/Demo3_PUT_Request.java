package restsssuredTests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
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

public class Demo3_PUT_Request {
	
	String id;
	
	@Test (priority=1)
	public void postData() throws FileNotFoundException
	{
		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";
		
		id=given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://api.restful-api.dev/objects")
			.jsonPath().getString("id");
		System.out.println(id);

	}
	
	@Test (priority=1, dependsOnMethods = {"postData"})
	public void putData() throws FileNotFoundException
	{
		File f = new File(".//Demo3body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		RestAssured.baseURI = "https://api.restful-api.dev";
		RestAssured.basePath = "/objects";
		System.out.println(id);
		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.put("https://api.restful-api.dev/objects/"+id)
		.then()
		.statusCode(200)
		.statusLine("HTTP/1.1 200 ")
		.headers("Content-Type","application/json")
		.assertThat().body("id",equalTo(id))
		.assertThat().body("name",equalTo("Apple MacBook Pro 17"))
		.assertThat().body("data.year",equalTo(2020))
		.assertThat().body("data.price",equalTo(1850.99F))
		.assertThat().body("data.'CPU model'",equalTo("Intel Core i10"))
		.assertThat().body("data.'Hard disk size'",equalTo("2 TB"))	
		.log().all();

	}
	
	@Test (priority=3)
	public void deleteRecord()
	{
		RestAssured.baseURI = "https://api.restful-api.dev/objects";
		RestAssured.basePath = "/"+id;
		
		Response res=
		given()		
		.when()
		.delete()
		.then()
			.statusCode(200)
			.log().all()
			.extract().response();
		
		String JSONString = res.asString();
		Assert.assertEquals(JSONString.contains("Object with id = "+id+" has been deleted."),true);
	}
}