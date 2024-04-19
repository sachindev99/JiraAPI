package testcases;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;
public class AddAComment {
	public static String commentId;
	public static String addCommentDetails;
	@Test
	public void addCommentToIssue() {
		//we need a session id which gets created on successfully login
		RestAssured.baseURI = "http://localhost:8080/";
		//login
		//we can also use the JSONPath class to parse the Json and use getString() method to extract the session id
		//but rest Assured provides a class SessionFilter which helps to reterive the session id
	
		SessionFilter session =  new SessionFilter();
		String response= given().header("Content-Type","application/json").body(Payload.credentials()).log().all().filter(session).
		when().post("rest/auth/1/session").
		then().assertThat().extract().response().asString();
		
		System.out.println(response);
		
		//using path parameter
		addCommentDetails = given().header("Content-Type","application/json").pathParam("ID", "10001").body(Payload.addCommentDetails()).filter(session).
		//using path parameter here
		when().post("rest/api/2/issue/{ID}/comment").
		then().assertThat().statusCode(201).extract().asString();
		System.out.println(addCommentDetails);
		
	}
	

}
