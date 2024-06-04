package jsonparsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJSONParse {
	
	@Test
	public void ComplexJsonParseMethod() throws IOException
	{
		//external JSON file to byte data -> byte data to string
		String payloadString = new String (Files.readAllBytes(Paths.get("/Users/leelasan/git/Automation/Eclipse-MacWorkspace/RestAssuredAPITesting_BDD_Project/payload.json")));
		JsonPath js = new JsonPath(payloadString);

		//The below statement directly take the json string and get's the required data with the JsonPath Methods
		//JsonPath js = new JsonPath(payload.CoursePrice());
		
		//1. Print No of courses returned by API

		System.out.println(js.getInt("courses.size()"));
		
		//2.Print Purchase Amount
		
		System.out.println(js.getInt("dashboard.purchaseAmount"));
		
		//3. Print Title of the first course

		System.out.println(js.getString("courses[0].title"));

		//4. Print All course titles and their respective Prices

		for(int i=0; i<(js.getInt("courses.size()")); i++)
		{
			System.out.println(js.getString("courses["+i+"].title")+" "+js.getInt("courses["+i+"].price"));
		}
		
		//5. Print no of copies sold by RPA Course
		
		for(int j=0; j<(js.getInt("courses.size()")); j++)
		{
			String title = js.getString("courses["+j+"].title");

			if (title.equalsIgnoreCase("RPA"))
			{
				System.out.println("number of copies of RPA");
				System.out.println(js.getInt("courses["+j+"].copies"));
				break;
			}
		}
		
		//6. Verify if Sum of all Course prices matches with Purchase Amount
		
		int total=0;
		
		for(int k=0; k<(js.getInt("courses.size()")); k++)
		{
			total = total + ((js.getInt("courses["+k+"].price")) * (js.getInt("courses["+k+"].copies")));
		}
		System.out.println("Total is: "+total);
		Assert.assertEquals(js.getInt("dashboard.purchaseAmount"), total);
	}
	
}
