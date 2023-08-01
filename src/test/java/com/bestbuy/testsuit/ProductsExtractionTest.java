package com.bestbuy.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
    }

    //21. Extract the limit
    @Test
    public void limit() {

        int limit = response.extract().path("limit");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void total() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void productname() {
        String fifthProduct = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the name of 5th product " + fifthProduct);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void allProduct() {
        List<String> Product = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the name all product " + Product);
        System.out.println("------------------End of Test---------------------------");

    }

    //25. Extract the productId of all the products
    @Test
    public void productId() {
        List<String> allId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Extract the productId of all the products " + allId);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void dataList() {
        List<String> data = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Print the size of the data list " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
    //Pack)
    @Test
    public void productNameEne() {
        List<HashMap<String, ?>> data = response.extract().path("data.findAll{it.name == 'Energizer-MAX Batteries AA (4-pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all the value of the product where product name = Energizer - MAX Batteries AA  " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    // Get the model of the product where product name = Energizer -N Cell E90 Batteries(2-Pack)
    @Test
    public void productModel() {
        String model = response.extract().path("data[8].model");
        System.out.println("-----------");

    }

    //    29. Get all the categories of 8th products
    @Test
    public void verifyAllCategoriesOf8Product() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the categories of 8th products" + categories);
        System.out.println("------------------End of Test---------------------------");

    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void verifyCategoriesOfTheStoreWhereProductID150115() {
        List<HashMap<String, ?>> categoriesAll = response.extract().path("data.findAll{it.id == '150115'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get categories of the store where product id = 150115" + categoriesAll);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get all the descriptions of all the products
    @Test
    public void verifyDescription() {
        List<String> descriptions = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the descriptions of all the products" + descriptions);
        System.out.println("------------------End of Test---------------------------");

    }

    //Get id of all the all categories of all the products
    @Test
    public void verifyAllCategories() {
        List<String> categories = response.extract().path("data.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Get all the categories of all the products" + categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //33.Find the product names Where type = HardGood

    @Test
    public void productName() {
        List<HashMap<String, ?>> HardGood = response.extract().path("data.findAll{it.type == 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the product names Where type  HardGood " + HardGood);
        System.out.println("------------------End of Test---------------------------");

    }

    /*  34. Find the Total number of categories for the product where product name = Duracell - AA
      1.5V CopperTop Batteries (4-Pack)*/
    @Test
    public void totalNumberOfCategories() {
        List<String> categories = response.extract().path("data.findAll{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void allProductPrice() {
        List<String> createdAt = response.extract().path("data.findAll{it.price == 5.49f}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the createdAt for all products whose price 5.49" + createdAt);
        System.out.println("------------------End of Test---------------------------");


    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)”/
    @Test
    public void allProductName() {
        List<HashMap<String, ?>> name = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4- Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)" + name);
        System.out.println("------------------End of Test---------------------------");


    }

    //37. Find the manufacturer of all the products
    @Test
    public void manufactureOFAllProduct() {
        List<String> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the manufacturer of all the products" + manufacturer);
        System.out.println("------------------End of Test---------------------------");

    }

    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void imgofAllProduct() {
        List<HashMap<String, ?>> Energizer = response.extract().path("data.findAll{it.manufacturer=='Energizer'}.image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" the image of products whose manufacturer is = Energizer" + Energizer);
        System.out.println("------------------End of Test---------------------------");

    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void createAtPrice() {

        List<String> createdAt1 = response.extract().path("data.findAll{it.price >= 5.99f}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the createdAt for all categories products whose price > 5.99" + createdAt1);
        System.out.println("------------------End of Test---------------------------");

    }

    //40. Find the uri of all the products
    @Test
    public void uriAllProduct() {
        List<String> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" the uri of all the products" + url);
        System.out.println("------------------End of Test---------------------------");

    }
}
