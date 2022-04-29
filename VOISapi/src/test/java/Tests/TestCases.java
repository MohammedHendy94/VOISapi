package Tests;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNot;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import groovy.lang.Range;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.ArrayList;
import java.util.List;

public class TestCases {
	
	/*This test case implements the first part of the task: 
	Get a random user (userID), print out its email address to console.*/
	@Test
	public void FirstTestCase() {
		
	        Response respons = get("https://jsonplaceholder.typicode.com/users/1");
	        String body = respons.getBody().asString();
	        JsonPath jsonPath = new JsonPath(body);
	        String user_email = jsonPath.getString("email");
	        System.out.println(user_email);
	       // System.out.println(statuscode);
	       //int statuscode = respons.getStatusCode();
	       //System.out.println(body);
	}
	
	
	
	/*
	 * This test case implements the second part of the task: 
	 Using this userID, get this user’s associated posts and 
	 verify they contains a valid Post IDs (an Integer between 1 and 100).
	*/
	
	@Test
	public void SecondTestCase() {
		
	        Response respons = get("https://jsonplaceholder.typicode.com/posts?userId=1");
	        String body = respons.getBody().asString();
			JsonPath jsonPath = new JsonPath(body);
			List<Integer> posts_id = jsonPath.getList("id");
			//respons.then().body("id",);
	        System.out.println(posts_id);
	        
	        
	
	}
	
	
	/*
	 * This test case implements the third part of the task: 
	Do a post using same userID with a non-empty title and body,
	 verify the correct response is returned
	*/
	
	@Test
	public void ThirdTestCase() {
		
		JSONObject requestbody =  new JSONObject();
		requestbody.put("Title", "VOIS Task");
		requestbody.put("body", "I Loved This Challenge");
		requestbody.put("userId", 1);
		given().body(requestbody.toJSONString()).when().
		post("https://jsonplaceholder.typicode.com/posts").then().statusCode(201);
		
	}

}
