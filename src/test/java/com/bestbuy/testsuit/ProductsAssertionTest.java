package com.bestbuy.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.hasItem;

public class ProductsAssertionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);


//19. Verify the ProductId = 333179 for the 9th product
//20. Verify the prodctId = 346575 have 5 categories
//}
    }

    //  11. Verify the if the total is equal to 51957
    @Test
    public void verifyTotal() {
        response.body("total", equalTo(51957));
    }

    //  12. Verify the if the stores of limit is equal to 10
    @Test
    public void verifyLimits() {
        response.body("limits", equalTo(10));
    }

    //  13. Check the single ‘Name’ in the Array list (Duracell - AAA Batteries (4-Pack))
    @Test
    public void checkSingleNameInArray() {
        response.body("data.name", hasItem("Duracell - AAA Batteries (4-Pack)"));
    }

    //   14. Check the multiple ‘Names’ in the ArrayList (Duracell - AA 1.5V CopperTop Batteries (4-Pack), Duracell - AA Batteries (8-Pack), Energizer - MAX Batteries AA (4-Pack))
    @Test
    public void checkMultipleNamesInArray() {
        response.body("data.name", hasItems("Duracell - AA 1.5V CopperTop Batteries (4-Pack)", "Duracell - AA Batteries (8-Pack)", "Energizer - MAX Batteries AA (4-Pack)"));
    }

    //  15. Verify the productId=150115 inside categories of the third name is “Household Batteries”
    @Test
    public void productId() {
        response.body("data[2].categories[2].name", equalTo("Household Batteries"));
    }

    //     16. Verify the categories second name = “Housewares” of productID = 333179
    @Test
    public void secondName() {
        response.body("data[1].categories[1].name", equalTo("Housewares"));
    }

    // Verify the price = 4.99 of forth product
    @Test
    public void priceOfProduct() {
        response.body("data[3].price", equalTo(4.99f));
    }

    //  Verify the Product name = Duracell - D Batteries (4-Pack) of 6th product
    @Test
    public void verify6thProductName() {
        response.body("data[5].name", equalTo("Duracell - D Batteries (4-Pack)"));

    }

    @Test
    public void verifyProductIdOf9thProduct() {
        response.body("data[8].id", equalTo(333179));
    }

    @Test
    public void productId34() {
        response.body("data[9].id", equalTo(346575));

    }
}