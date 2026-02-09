package com.api.tests.calculator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import io.restassured.response.Response;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class CallingAPI {
	@Test
	public void testCase() {
//		Map<String, Object> bodyParams = new HashMap<>();		
//	    bodyParams.put("expr", "2*(7-3)");
//	    bodyParams.put("precision", 14);
		/*
		 {
    "expr": [
      "a = 1.2 * (2 + 4.5)",
      "a / 2",
      "5.08 cm in inch",
      "sin(45 deg) ^ 2",
      "9 / 3 + 2i",
      "b = [-1, 2; 3, 1]",
      "det(b)"
    ],
    "precision": 14
  }
		 */
	    Map<String, String> headers1 = new HashMap<>();
	    headers1.put("Content-Type", "application/json");
	    JSONObject json = new JSONObject();
	    json.put("expr", "[a = 1.2 * (2 + 4.5), a / 2, 5.08 cm in inch]");
	    json.put("precision", "14");
		baseURI = "http://api.mathjs.org";
		Response response = given()
	            .headers(headers1)
	            .body(json.toString())
	        .when()
	            .post("/v4") 
	        .then()
	            .statusCode(200)       // Validates the response status
	            .extract()
	            .response();
		response.prettyPrint();
	}
}
