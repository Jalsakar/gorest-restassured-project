package com.gorest.testsuite;

import com.gorest.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * 1. Verify the total record is 25
 * 2. Verify the title of id = 93997 is equal to "Demitto conqueror atavus argumentum corrupti cohaero libero."
 * 3. Check the single user_id in the Array list (5914249)
 * 4. Check the multiple ids in the ArrayList (5914243, 5914202, 5914199)
 * 5. Verify the body of userid = 5914197 is equal “Desidero vorax adsum. Non confero clarus.
 * Velut defessus acceptus. Alioqui dignissimos alter. Tracto vel sordeo. Vulpes curso tollo.
 * Villa ususvos. Terreo vos curtus. Condico correptius praesentium. Curatio deripio attero.
 * Tempus creptio tumultus. Adhuc consequatur undique. Adaugeo terminatio antiquus.
 * Stultus ex temptatio. Autus acerbitas civitas. Comptus terminatio tertius.
 * Utpote fugit voluptas. Sequi adulescens caecus.”
 */

public class PostsAssertionTest extends TestBase {
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

    //* 1. Verify the total record is 25
    @Test
    public void test001(){
        response.body("total.size()", equalTo(25));
    }

    // * 2. Verify the title of id = 93997 is equal to "Demitto conqueror atavus argumentum corrupti cohaero libero."
    @Test
    public void test002(){
        response.body("[14].title", equalTo("Et socius caries tamquam defendo voluptas claudeo utpote."));
    }

    // * 3. Check the single user_id in the Array list (5914249)
    @Test
    public void test003(){
        response.body("user_id" , hasItem(5914141));
    }

    // * 4. Check the multiple ids in the ArrayList (5914243, 5914202, 5914199)
    @Test
    public void test004(){
        response.body("id", hasItems(93967, 93942, 94000));
    }

    // * 5. Verify the body of userid = 5914197 is equal “Desidero vorax adsum. Non confero clarus.
    // * Velut defessus acceptus. Alioqui dignissimos alter. Tracto vel sordeo. Vulpes curso tollo.
    // * Villa ususvos. Terreo vos curtus. Condico correptius praesentium. Curatio deripio attero.
    // * Tempus creptio tumultus. Adhuc consequatur undique. Adaugeo terminatio antiquus.
    // * Stultus ex temptatio. Autus acerbitas civitas. Comptus terminatio tertius.
    // * Utpote fugit voluptas. Sequi adulescens caecus.”
    @Test
    public void test005(){
        response.body("find{it.user_id == 5914188 }.body", equalTo("Cohibeo tabernus sequi. Valeo cibus minima. Cum conduco dolorum. Et accusator utrum. Voluptatibus color alveus. Allatus vulnus acceptus. Centum clamo astrum. Aeternus aestus voluptas. Thorax aeger dolores. Caelum spoliatio tandem. Approbo tertius vester."));
    }
}
