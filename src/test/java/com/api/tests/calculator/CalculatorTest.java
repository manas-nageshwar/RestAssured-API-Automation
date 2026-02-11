package com.api.tests.calculator;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest {
	// Initialize the API Object
    CalculatorAPI calculator = new CalculatorAPI();

    @Test
    public void verifyMultiplication() {
        // Perform action
        Response response = calculator.getCalculation("5*5");
        System.out.println(response.jsonPath().getString("result"));
        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        String result = response.jsonPath().getString("result");
        Assert.assertEquals(result, "25", "Multiplication result mismatch!");
    }

    @Test
    public void verifyDivision() {
        Response response = calculator.getCalculation("10/2");        
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("result"), "5");
    }
    @Test
    public void verifySubtraction() {
    	Response response = calculator.getCalculation("10-9");
    	Assert.assertEquals(response.statusCode(), 200);
    	Assert.assertEquals(response.jsonPath().getString("result"), "1");
    }
}
