package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UsersPutOrPatchTest extends TestBase {

    // ======================Update the new user===============================//

    @Test
    public void verifyUserUpdateSuccessfully() {

        UserPojo userPojo = new UserPojo();
        String email = TestUtils.getRandomValue() + "disha123@gmail.com";
        userPojo.setEmail(email);

        Response response = given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 22569421895bacfdab09c3342e55ad05fa445d1c97cd3f6bc2466e2fabf00a05")
                .pathParam("id", 5)
                .when()
                .body(userPojo)
                .when().patch("/public/v2/users/{id}");
        response.prettyPrint();

    }
}
