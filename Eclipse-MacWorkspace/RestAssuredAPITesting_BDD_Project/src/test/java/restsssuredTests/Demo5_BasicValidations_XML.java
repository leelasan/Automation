package restsssuredTests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.*;

public class Demo5_BasicValidations_XML {
	
	@Test
	public void testXMLAPI()
	{
		given()
			.when()
				.get("https://mocktarget.apigee.net/xml")
			.then()
			.body("root.city",equalTo("San Jose"))
			.body("root.firstName",equalTo("John"))
			.body("root.lastName",equalTo("Doe"))
			.body("root.state",equalTo("CA"))
			
			.body("root.text()",equalTo("San JoseJohnDoeCA"))
			
			.body(hasXPath("/root/city",containsString("San Jose")))
			.body(hasXPath("/root/firstName",containsString("John")))
			.body(hasXPath("/root/lastName",containsString("Doe")))
			.body(hasXPath("/root/state",containsString("CA")))
			.log().all();
	}
	
	@Test
	public void testUsingXPATH()
	{
		given()
			.when()
				.get("https://thetestrequest.com/authors.xml")
			.then()
			.body(hasXPath("/objects/object/name[text()='Dede Tillman']"));
	}
}
