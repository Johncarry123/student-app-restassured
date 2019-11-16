package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Created by Jay
 */
public class StudentPostTest extends TestBase {


    @Test
    public void createNewStudent(){
        List<String> cources = new ArrayList<>();
        cources.add("Java");
        cources.add("C++");

        StudentPojo studentPojo = new StudentPojo();
        studentPojo.setFirstName("Prime2");
        studentPojo.setLastName("Testing");
        studentPojo.setEmail("test123@gmail.com");
        studentPojo.setProgramme("Automation Testing");
        studentPojo.setCources(cources);

        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .body(studentPojo)
                .post();
        response.then().log().all().statusCode(201);
    }

}
