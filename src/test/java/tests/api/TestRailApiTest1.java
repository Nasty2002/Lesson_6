package tests.api;

import enums.ProjectType;
import models.ProjectBuilder;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestRailApiTest1 {

    @Test
    public void getAllProjects() {
        String endpoint = "/index.php?/api/v2/get_projects";

        given()
                .when()
                .get(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject1() {
        String endpoint = "/index.php?/api/v2/get_projects";

        ProjectBuilder project = ProjectBuilder.builder()
                .name()
                .annuncement()
                .isShowAnnouncement()
                .typeOfProject()
                .build();

        given()
                .body()
                .when()
                .post(endpoint)
                .then().log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject2() {
        String endpoint = "/index.php?/api/v2/get_projects";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_02")
                .typeOfProject(ProjectType.SINGLE)
                .build();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", project.getName());
        jsonMap.put("suite_mode", project.getTypeOfProject().getProjectType());

        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void addProject3() {
        String endpoint = "/index.php?/api/v2/get_projects";

        ProjectBuilder project = ProjectBuilder.builder()
                .name("WP_Project_02")
                .typeOfProject(ProjectType.SINGLE)
                .build();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", project.getName());
        jsonMap.put("suite_mode", project.getTypeOfProject().getProjectType());

        given()
                .body(jsonMap)
                .when()
                .post(endpoint)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);
    }
}