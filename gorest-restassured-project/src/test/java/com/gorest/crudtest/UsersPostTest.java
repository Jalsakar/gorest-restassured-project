package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersPostTest extends TestBase {

    //==================Create a user and find the user ID========================//
    @Test
    public void verifyUserCreatedSuccessfully() {

        UserPojo userPojo=new UserPojo();
        userPojo.setName("Malak");
        userPojo.setEmail("malak19@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");

        Response response=given().log().all()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 22569421895bacfdab09c3342e55ad05fa445d1c97cd3f6bc2466e2fabf00a05")
                .when()
                .body(userPojo)
                .post("/users");
        response.then().log().all().statusCode(201);
        response.prettyPrint();
    }
}
