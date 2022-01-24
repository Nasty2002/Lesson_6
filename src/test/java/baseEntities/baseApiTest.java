package baseEntities;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.given;

public class baseApiTest {

    @BeforeTest
    public void setUpApiTest(){
        // Setup RestAssured
        RestAssured.baseURI = ReadProperties.getUrl();

        // Setup request Object
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);
    }
}
