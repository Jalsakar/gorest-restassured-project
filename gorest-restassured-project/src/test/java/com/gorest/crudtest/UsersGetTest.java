package com.gorest.crudtest;

import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersGetTest extends TestBase {

    //=============================Find the new user by ID==========================//

    @Test
    public void verifyNewUserInfo() {
        Response response = given()
                .header("Content-Type","application/json")
                .header("Authorization","Bearer 22569421895bacfdab09c3342e55ad05fa445d1c97cd3f6bc2466e2fabf00a05")
                .queryParams("id", 94000)
                .when()
                .get("/posts");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
