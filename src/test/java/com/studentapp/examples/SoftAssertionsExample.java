package com.studentapp.examples;

import com.studentapp.testbase.TestBase;
import io.restassured.RestAssured;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

/**
 * Created by Jay
 */
public class SoftAssertionsExample extends TestBase {

    @Test
    public void hardAssert() {
        RestAssured.given()
                .when()
                .get("/list")
                .then()
                .body("[0].firstName", equalTo("Vernon1"))
                .body("[0].lastName", equalTo("Harper"))
                .body("[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"))
                .body("[0].programme", equalTo("Financial Analysis1"));
    }

    @Test
    public void softAssert() {
        RestAssured.given()
                .when()
                .get("http://localhost:8080/student/list")
                .then()
                .body("[0].firstName", equalTo("Vernon1"),
                        "[0].lastName", equalTo("Harper"),
                        "[0].email", equalTo("egestas.rhoncus.Proin@massaQuisqueporttitor.org"),
                        "[0].programme", equalTo("Financial1 Analysis")
                );

    }
}
