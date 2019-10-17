package com.qa.tests.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jsongettest1 {

	@Test 
	void getJSONemployeetest(){
		
		RestAssured.baseURI = ("http://dummy.restapiexample.com/api/v1");
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response resoponse = httpRequest.request(Method.GET,"employees");
		
		String responsebody = resoponse.getBody().asString();
		
		System.out.println(responsebody);
		
		int statuscode = resoponse.getStatusCode();
		System.out.println(statuscode);
		
		String statustline = resoponse.getStatusLine();
		System.out.println(statustline);
		
		
		
		
	}
	
   @Test (priority = 1)
   void gettestsingleemployee(){
	   
	   RestAssured.baseURI = ("http://dummy.restapiexample.com/api/v1/employee");
	   
	   RequestSpecification httpRequest = RestAssured.given();
	   
	   Response response = httpRequest.request(Method.GET,"/employee/1");
	   
	   String reponsebody = response.getBody().asString();
	   
	   System.out.println(reponsebody);
	   
	   
	   
   }
	
  @Test
  
  void Postrequest(){
	  
	  RestAssured.baseURI = ("http://dummy.restapiexample.com/api/v1");
	  
	  RequestSpecification httpRequest = RestAssured.given();
	  
	  JSONObject requestParams = new JSONObject();
		//add parameters as par of post request
		requestParams.put("Name","Kishore");
		requestParams.put("salary","1000");
		requestParams.put("age","25");
		//specify the foramt of data (json,xml..etc)
		httpRequest.header("content Type","application/json");
		
		httpRequest.body(requestParams.toString());//attach data to the request
		
		//Step 4 send request after the dataset up
		Response response =httpRequest.request(Method.POST,"/create");
		
		//
		String responsebody =  response.getBody().asString();
		System.out.println("response body is :"+responsebody);
		
		int statuscode = response.statusCode();
		System.out.println("status code is :"+statuscode);
		Assert.assertEquals(statuscode, 520);
		
		//String succcesscode = response.jsonPath().get("SuccessCode");
		//Assert.assertEquals(succcesscode,"OPERATION SUCCESS");
		
	  
		//{"name":"test","salary":"123","age":"23"}
	  
	  	  
	  
  }
  
	
}
