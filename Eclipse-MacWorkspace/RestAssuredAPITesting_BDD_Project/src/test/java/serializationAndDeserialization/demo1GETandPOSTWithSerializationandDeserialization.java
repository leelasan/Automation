package serializationAndDeserialization;

import static io.restassured.RestAssured.*;
import java.util.ArrayList;
import org.testng.annotations.Test;

public class demo1GETandPOSTWithSerializationandDeserialization {
	String Rid;
	@Test(priority =1)
	public void testPUTwithSerialization(){
		ArrayList<Object> dataArr = new ArrayList<Object>();
		dataArr.add(2019);
		dataArr.add(1849.99);
		dataArr.add("Intel Core i9");
		dataArr.add("1 TB");
		demo1dataObject dObj = new demo1dataObject();
		dObj.setName("Apple MacBook Pro 16");
		dObj.setData(dataArr);
		
		//Sending object to file with a PUT request is nothing but Serialization here
		Rid=given()
				.contentType("application/json")
				.body(dObj)
			.when()
				.post("https://api.restful-api.dev//objects")
				.jsonPath().getString("id");
		System.out.println(Rid);
	}
	
	@Test(priority =2)
	public void testGetwithDeSerialization(){
		demo1dataObject dobj1 = get("https://api.restful-api.dev//objects/"+Rid).as(demo1dataObject.class);		
		dobj1.getObjRecord();
	}
	
	@Test(priority =3)
	public void testDelete(){
		delete(("https://api.restful-api.dev//objects/"+Rid));
	}
}
