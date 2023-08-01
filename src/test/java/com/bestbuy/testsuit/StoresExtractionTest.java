package com.bestbuy.testsuit;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
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



    @Test
    public void limitExtract1() {
        int limit = response.extract().path("limit");
        System.out.println("Extract the limit " + limit);
    }

    // Extract the total
    @Test
    public void totalExtract2() {
        int total = response.extract().path("total");
        System.out.println("Extract the total " + total);
    }

    @Test
    public void name3() {
        System name = response.extract().path("*data[4].name");
        System.out.println("extract name of fifth store" + name);
    }

    @Test
    public void storeId5() {
        System id = response.extract().path("*data.id");
        System.out.println("extract name of fifth store" + id);
    }

    @Test
    public void sizeOfList6() {
        List<String> dataList = response.extract().path("data");
        System.out.println("Extract the size of data list " + dataList.size());
    }

    @Test
    public void valueStore7() {
        List<HashMap<String, String>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("Get all the value of the store where store name = St Cloud " + values);

    }

    @Test
    public void address8() {
        List<HashMap<String, String>> address = response.extract().path("data.findAll{it.name == 'Rochester'}");
        System.out.println("Get all the value of the store where store name = Rochester " + address);

    }

    @Test
    public void getAllServices9() {
        List<String> services = response.extract().path("data[7].services");
        System.out.println("Get all the services of the store where store id 7 store " + services);

    }

    @Test
    public void getWindoStoreServices10() {
        List<HashMap<String, ?>> services1 = response.extract().path("data.services*.findAll{it.name == 'windows store'}");
        System.out.println("Get all the value of the store where store name = Rochester " + services1);

    }

    @Test
    public void idOfAllStore12() {
        List<?> latName = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores " + latName);
    }

    @Test
    public void storeIfOfAllStore11() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the store " + storeId);
    }

    @Test
    public void state13() {
        List<String> state = response.extract().path("data.findAll{it.name == 'Nd'}.name");
        System.out.println("Find the store names Where state = ND" + state);
    }

    @Test
    public void rochesterServices14() {
        List<String> rochesterServices = response.extract().path("data.findAll{it.name =='Rochester'}.name");
        System.out.println("Find the Total number of services for the store where store name = Rochester" + rochesterServices);
    }

    @Test
    public void windowsServices15() {
        //Find the createdAt for all services whose name = “Windows Store”
        List<HashMap<String, ?>> windowServices = response.extract().path("data.services*.findAll{it.name=='Windows Store'}.storeServices.createdAt");
        System.out.println("Find the createdAt for all services whose name = “Windows Store" + windowServices);
    }

    @Test
    public void fargo16() {
        List<String> fargoServices = response.extract().path("data.findAll{it.name == 'Fargo'}services*.name");
        System.out.println("Find the name of all services Where store name = Fargo" + fargoServices);
    }

    @Test
    public void zipOfStore17() {
        List<String> zip = response.extract().path("data.zip");
        System.out.println("Find the zip of all the stor" + zip);
    }

    @Test
    public void zipStoreName18() {
        List<String> zipStoreName = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("Find the zip of store name = Roseville" + zipStoreName);
    }

    @Test
    public void magnolia19() {
        List<HashMap<String, ?>> magnoliaServices = response.extract().path("data.services*.findAll{it.name=='Magnolia Home Theater'}.name");
        System.out.println("Find the storeservices details of the service name = Magnolia Home Theater" + magnoliaServices);
    }

    @Test
    public void latData20() {
        List<?> late = response.extract().path("data.lat");
        System.out.println("Find the lat of all the store" + late);
    }

}

