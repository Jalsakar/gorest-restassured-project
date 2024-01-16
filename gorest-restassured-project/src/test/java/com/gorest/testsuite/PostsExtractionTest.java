package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * 1. Extract the title
 * 2. Extract the total number of record
 * 3. Extract the body of 15th record
 * 4. Extract the user_id of all the records
 * 5. Extract the title of all the records
 * 6. Extract the title of all records whose user_id = 5914200
 * 7. Extract the body of all records whose id = 93957
 */

public class PostsExtractionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 25)
                .when()
                .get("/posts")
                .then().statusCode(200);
    }

    //* 1. Extract the title
    @Test
    public void test001() {
        List<String> title = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + title);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 2. Extract the total number of record
    @Test
    public void test002() {
        List<Integer> noOfRecords = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + noOfRecords.size());
        System.out.println("------------------End of Test---------------------------");
    }

    // * 3. Extract the body of 15th record
    @Test
    public void test003() {
        String body = response.extract().path("[14].body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + body);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 4. Extract the user_id of all the records
    @Test
    public void test004() {
        List<Integer> userIDs = response.extract().path("user_id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + userIDs);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 5. Extract the title of all the records
    @Test
    public void test005() {
        List<String> titles = response.extract().path("title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + titles);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 6. Extract the title of all records whose user_id = 5914200
    @Test
    public void test006() {
        List<String> title = response.extract().path("findAll{it.user_id == 5914193}.title");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + title);
        System.out.println("------------------End of Test---------------------------");
    }

    // * 7. Extract the body of all records whose id = 93957
    @Test
    public void test007() {
        List<String> body = response.extract().path("findAll{it.id == 93949}.body");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + body);
        System.out.println("------------------End of Test---------------------------");
    }
}
