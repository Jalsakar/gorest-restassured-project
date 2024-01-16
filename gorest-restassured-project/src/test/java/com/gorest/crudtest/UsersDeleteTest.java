package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersDeleteTest extends TestBase {

    //======================Delete the new user===============================//

    @Test
    public void verifyUserDeleteSuccessfully() {
        UserPojo userPojo = new UserPojo();
        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 22569421895bacfdab09c3342e55ad05fa445d1c97cd3f6bc2466e2fabf00a05")
                .pathParam("id", 5)
                .when()
                .body(userPojo)
                .when().delete("/public/v2/users/{id}");
        response.prettyPrint();
    }
}
