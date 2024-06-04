package restsssuredTests;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.BasePatheNumClasses;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Demo3_PUT_Request {
	
	String id;
	public static RequestSpecification req;
	public static ResponseSpecification res;
	
	@Test (priority=1)
	public void postData() throws IOException
	{
		//File f = new File(".//body.json");
		//FileReader fr = new FileReader(f);
		//JSONTokener jt = new JSONTokener(fr);
		//JSONObject data = new JSONObject(jt);
		
		String data = new String (Files.readAllBytes(Paths.get(".//body.json")));
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/leelasan/git/Automation/Eclipse-MacWorkspace/RestAssuredAPITesting_BDD_Project/src/test/java/resources/global.properties");
		prop.load(fis);

		//just in case executed for multiple data, log will carry all log instead of wiping out for every test case
		if (req == null)
		{
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri(prop.getProperty("baseUrl")).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.build();	
		}
		
		//in BDD framework with the parameter which gets value from examples, will go to 'valueOf' value
		//for understanding, i just passed it here directly.
		BasePatheNumClasses obj = BasePatheNumClasses.valueOf("postDataBasePathURL");
		
		id=given().spec(req)
			.body(data)
		.when()
			.post(obj.getResource())
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
		
		res = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectStatusLine("HTTP/1.1 200 ")
				.expectContentType(ContentType.JSON)
				.expectBody("id",equalTo(id))
				.expectBody("name",equalTo("Apple MacBook Pro 17"))
				.expectBody("data.year",equalTo(2020))
				.expectBody("data.price",equalTo(1850.99F))
				.expectBody("data.'CPU model'",equalTo("Intel Core i10"))
				.expectBody("data.'Hard disk size'",equalTo("2 TB"))
				.build();

		
		given()
			.contentType("application/json")
			.body(data.toString())
		.when()
			.put("https://api.restful-api.dev/objects/"+id)
		.then().spec(res)
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