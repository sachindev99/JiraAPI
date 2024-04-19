package testcases;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

public class AddAnAttachment {
	@Test
	public void addAnAttachment() {
		RestAssured.baseURI = "http://localhost:8080/";
		SessionFilter session = new SessionFilter();
		String response=  given().header("Content-Type","application/json").body(Payload.credentials()).filter(session).
		when().post("rest/auth/1/session").
		then().assertThat().extract().response().asString();
		System.out.println(response);
		
		//using multiPart method to add an attachment
		given().header("X-Atlassian-Token","no-check").pathParam("Id", "10001").filter(session).multiPart("file", new File("Info.txt")).
		when().post("rest/api/2/issue/{Id}/attachments").
		then().log().all().assertThat().statusCode(200);
		
		
	}
	

}
