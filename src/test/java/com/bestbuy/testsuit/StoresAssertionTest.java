package com.bestbuy.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class StoresAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //Verify the if the total is equal to 1561
    @Test
    public void total() {
        response.body("total", equalTo(1561));
    }

    //Verify the if the stores of limit is equal to 10

    @Test
    public void limit() {
        response.body("limit", equalTo(10));
    }

    //Check the single ‘Name’ in the Array list (Inver Grove Heights)
    @Test
    public void singleName() {
        response.body("data[1].name", equalTo("Inver Grove Heights"));
    }

    @Test
    public void listOfName() {

        response.body("data.name", hasItems("Roseville", "Burnsville", "Maplewood"));
    }

    //5. Verify the storied=7 inside storeservices of the third store of second services
    @Test
    public void storId7() {
        response.body("data[2].services[2].storeservices", equalTo("updatedAt: 2016-11-17T17:57:09.417Z"));
    }
//6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville


    //7. Verify the state = MN of forth store
    @Test
    public void forthStore() {
        response.body("data[3].state", equalTo("MN"));
    }

    //8. Verify the store name = Rochester of 9th store
    @Test
    public void rochester() {
        response.body("data[8].name", equalTo("Rochester"));
    }

    //9. Verify the storeId = 11 for the 6th store
    @Test
    public void storeId11() {

        response.body("data[5].id", equalTo(11));
    }

    //10. Verify the serviceId = 4 for the 7th store of forth service
    @Test
    public void serviceId() {
        response.body("data[7].services[3].id", equalTo(4));
    }

}
