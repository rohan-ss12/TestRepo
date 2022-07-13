package ResReq.ResReq;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClasses.RequestBodyPoJo;
import pojoClasses.ResponsePoJo;


public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		
		RestAssured.baseURI = "https://rahulshettyacademy.com/";
		
		RequestBodyPoJo reqPoJo = new RequestBodyPoJo();
		
		reqPoJo.name = "BookName";
		reqPoJo.isbn = "BK0003";
		reqPoJo.aisle = "2739";
		reqPoJo.author = "BookAuthor";
		
	
		
		Response response = given().header("Content-Type","application/json")
		.body(reqPoJo).log().all()
		.when().post("Library/Addbook.php");
		
		response.as(ResponsePoJo.class);
		
		ResponsePoJo responsePoJo = new ResponsePoJo();
		
		responsePoJo.getID();
		
		
		
		
//		.then().assertThat().statusCode(200).log().all();
		
		
		
	}

}
