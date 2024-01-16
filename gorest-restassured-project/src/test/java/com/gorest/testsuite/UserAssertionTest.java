package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * 1. Verify the total record is 20
 * 2. Verify the name of id = 5914197 is equal to "Bhilangana Dhawan"
 * 3. Check the single ‘Name’ in the Array list (Dev Bhattacharya)
 * 4. Check the multiple ‘Names’ in the ArrayList (Usha Kaul Esq., Akshita Mishra, Chetanaanand Reddy )
 * 5. Verify the email of userid = 5914185 is equal “tandon_iv_aanandinii@prosacco.example”
 * 6. Verify the status is “Active” of username is “Amaresh Rana”
 * 7. Verify the Gender = male of username is “Dhanalakshmi Pothuvaal”
 */

public class UserAssertionTest extends TestBase {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    // * 1. Verify the total record is 20
    @Test
    public void test001() {
        response.body("total.size()", equalTo(20));
    }

    // * 2. Verify the name of id = 5914197 is equal to "Bhilangana Dhawan"
    @Test
    public void test002() {
        response.body("[1].name", equalTo("Prof. Chakrika Embranthiri"));
    }

    // * 3. Check the single ‘Name’ in the Array list (Dev Bhattacharya)
    @Test
    public void test003() {
        response.body("name", hasItem("Ekalavya Embranthiri"));
    }

    // * 4. Check the multiple ‘Names’ in the ArrayList (Usha Kaul Esq., Akshita Mishra, Chetanaanand Reddy )
    @Test
    public void test004() {
        response.body("name", hasItems("Abani Butt", "Asha Pandey", "Indra Trivedi II"));
    }

    // * 5. Verify the email of userid = 5914185 is equal “tandon_iv_aanandinii@prosacco.example”
    @Test
    public void test005() {
        response.body("[5].email", equalTo("prajapat_chandini@fisher.test"));
    }

    // * 6. Verify the status is “Active” of username is “Amaresh Rana”
    @Test
    public void test006() {
        response.body("[8].status", equalTo("active"));
    }

    // * 7. Verify the Gender = male of username is “Dhanalakshmi Pothuvaal”
    @Test
    public void test007() {
        response.body("[2].gender", equalTo("male"));
    }
}
