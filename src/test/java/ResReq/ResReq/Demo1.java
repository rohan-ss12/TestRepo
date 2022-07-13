package ResReq.ResReq;



import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClasses.RequestBodyPoJo;
import pojoClasses.ResponsePoJo;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;





public class Demo1 {
	
	public static void main(String args[]) {
		
		
		
		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/")
				.setContentType("application/json").build();
		
//		given().header("Content-Type","application/json")
//		.body("{\r\n"
//				+ "\"name\":\"paj\",\r\n"
//				+ "\"isbn\":\"jshf22249\",\r\n"
//				+ "\"aisle\":\"2910\",\r\n"
//				+ "\"author\":\"ppaqajsd\"\r\n"
//				+ "}")
//		.when().post("Library/Addbook.php")
//		.then().assertThat().statusCode(200).body("Msg", equalTo("succesfully added")).log().all();
		
		ResponsePoJo rp = new ResponsePoJo();
		
		RequestBodyPoJo reqP = new RequestBodyPoJo();
		reqP.name = "Rohan";
		reqP.isbn = "RSS009";
		reqP.aisle = "2910";
		reqP.author = "RSSTwo";
		
		
		RequestSpecification res = given().spec(reqSpec).body(reqP);
		
		Response response = res.when().post("Library/Addbook.php");
		
		response.then().log().all().assertThat().statusCode(200);
		
		rp = response.as(ResponsePoJo.class);
				
		
		
//		Response D1 = reqSpec.log().all().
////				.body("{\r\n"
////						+ "\"name\":\"RSSTwo\",\r\n"
////						+ "\"isbn\":\"RSS002\",\r\n"
////						+ "\"aisle\":\"2910\",\r\n"
////						+ "\"author\":\"RSSTwo\"\r\n"
////						+ "}")
//				.body(reqP)
//				.when().post("Library/Addbook.php");
//		
//		D1.then().log().all().assertThat().statusCode(200);
//		
//		rp = D1.as(ResponsePoJo.class);
				
		
		System.out.println(rp.getMsg());
		System.out.println(rp.getID());
		
		
		
		
	}
	
	
	
}
