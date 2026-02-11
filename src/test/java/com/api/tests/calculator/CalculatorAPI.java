package com.api.tests.calculator;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import utils.ConfigReader;

import org.json.JSONObject;
import java.util.Map;
import java.util.HashMap;

public class CalculatorAPI {
	// 1. Centralized Base URL and End points
    String v4Endpoint = ConfigReader.getProperty("v4Endpoint");
    String baseUri = ConfigReader.getProperty("baseUrl");
    // 2. Reusable method to perform a calculation
	public Response getCalculation(String expression) {
		// TODO Auto-generated method stub
		JSONObject json = new JSONObject();
		json.put("expr", expression);
		json.put("precision", "10");
		Map<String, String> headers = new HashMap<>();
		headers.put("content-type", "application/json");
		baseURI = baseUri;
		return given()
		.headers(headers)
		.body(json.toString())
		.when()
		.post(v4Endpoint);
		
	}
    
}
