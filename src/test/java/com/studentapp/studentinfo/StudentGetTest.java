package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class StudentGetTest extends TestBase {


    @Test
    public void getAllStudentInformation(){
        /**
         * given()
         * set cookies,add auth,adding parameters,setting header info
         * .when()
         * GET,POST,PUT,DELETE..etc
         * .then()
         *  Validate status code,extract response, extract headers,cookies,extract the response body
         *
         */
        Response response =given().log().all()
                .when()
                .get("/list");
        response.then().log().ifValidationFails().statusCode(201);


    }

    @Test
    public void getSingleInfo(){
        Response response =given()
                .when()
                .get("/1");
        System.out.println(response.prettyPrint());
    }

    @Test
    public void getSingleInfoWithParameter(){
        Response response =given()
                .param("programme", "Financial Analysis")
                .param("limit",2)
                .when()
                .get("/list");
        response.then().log().all().statusCode(200);
    }


}
