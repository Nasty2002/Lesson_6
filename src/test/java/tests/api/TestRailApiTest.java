package tests.api;

import core.ReadProperties;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRailApiTest {

    @Test
    public void simpleStepByStepApiTest() {

        // Setup endpoint
        String endpoint = "/index.php?/api/v2/get_users";


        // Setup request Object
        RequestSpecification httpRequest = given();
        httpRequest.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        httpRequest.auth().preemptive().basic(ReadProperties.getUsername(), ReadProperties.getPassword());

        // Setup response Object
        Response response = httpRequest.request(Method.GET, endpoint);

        // Get response Status
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        Assert.assertEquals(statusCode, 200);
        Assert.assertEquals(statusCode, HttpStatus.SC_OK); //равнозначно верхней строке

        // Get response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);
    }
}
