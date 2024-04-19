package jira;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

public class GetIssue {
 	
	@Test
	public void getAnIssueFromJiraDashboard() {
		RestAssured.baseURI = "http://localhost:8080/";
		SessionFilter session = new SessionFilter();
		String response=  given().relaxedHTTPSValidation().header("Content-Type","application/json").body(Payload.credentials()).filter(session).
		when().post("rest/auth/1/session").
		then().assertThat().extract().response().asString();
		System.out.println(response);
		
		//adding comment
		String addCommentDetails = given().header("Content-Type","application/json").pathParam("ID", "10001").body(Payload.addCommentDetails()).filter(session).
		//using path parameter here
		when().post("rest/api/2/issue/{ID}/comment").
		then().assertThat().statusCode(201).extract().asString();
		System.out.println(addCommentDetails);
		JsonPath js = files.ReusableMethods.rawToJson(addCommentDetails);
		String expectedCommentId = js.get("id");
		
		//get issue and extract only comment field
		String issueDetails= given().header("Content-Type","application/json").pathParam("ID", "10001").queryParam("fields","comment").filter(session).
		when().get("rest/api/2/issue/{ID}").
		then().log().all().assertThat().statusCode(200).extract().asString();
		
		JsonPath js1 = files.ReusableMethods.rawToJson(issueDetails);
		
		int commentSize = js1.getInt("fields.comment.total");
		
		for(int i=0;i<commentSize;i++) {
			
			String actualCommnetId = js1.getString("fields.comment.comments["+i+"].id");
			if(actualCommnetId.equals(expectedCommentId)) {
				System.out.println("Required comment body: "+ js1.getString("fields.comment.comments["+i+"].body"));
				System.out.println("Required comment id: "+js1.getString("fields.comment.comments["+i+"].id"));
				break;	
			}
		}
		

		
	}

}
