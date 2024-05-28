package serializationAndDeserialization;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class Demo2VideoGameAPITestwithSerializationXML {
	
	@Test(priority =1)
	public void testPOSTSerializationJSON() {
		Demo2VideoGame myVG = new Demo2VideoGame();
		myVG.setId(11);
		myVG.setName("xyz123");
		myVG.setReleaseDate("2024-05-22");
		myVG.setReviewScore(90);
		myVG.setCategory("Driving");
		myVG.setRating("Five");
		
		given()
			.contentType("application/xml")
			.body(myVG)
			.when()
				.post("http://localhost:8080/app/videogames")
				.then()
					.log().all()
					.body(equalTo("{\"status\": \"Record Added Successfully\"}"));
	}
	
	@Test(priority=2)
	public void testGETDeserializationJSON() {
		Demo2VideoGame myVG1 = get("http://localhost:8080/app/videogames/11").as(Demo2VideoGame.class);
		System.out.println(myVG1.showasString());
	}

}
