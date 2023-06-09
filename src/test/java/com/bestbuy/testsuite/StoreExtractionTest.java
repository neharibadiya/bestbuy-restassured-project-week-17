package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoreExtractionTest {

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

    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");

        System.out.println("___________________ StartingTest _________________");
        System.out.println("The value of limit is : " + limit);
        System.out.println("___________________ End Of Test __________________");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");

        System.out.println("___________________ StartingTest _________________");
        System.out.println("The value of limit is : " + total);
        System.out.println("___________________ End Of Test __________________");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String storeName = response.extract().path("data[4].name");

        System.out.println("___________________ StartingTest _________________");
        System.out.println("The value of limit is : " + storeName);
        System.out.println("___________________ End Of Test __________________");
    }
    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> allStoreName  = response.extract().path("data.name");

        System.out.println("___________________ StartingTest _________________");
        System.out.println("The value of limit is : " + allStoreName);
        System.out.println("___________________ End Of Test __________________");
    }
    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> allStoreId = response.extract().path("data.id");

        System.out.println("___________________ StartingTest _________________");
        System.out.println("The value of limit is : " + allStoreId);
        System.out.println("___________________ End Of Test __________________");
    }
    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> dataList = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All data list : " + dataList.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'St Cloud'}");

        System.out.println("---------------------StartingTest-----------------------");
        System.out.println("The value of the store where store name : " + values);
        System.out.println("----------------------End of test------------------------");
    }
    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<HashMap<String, ?>> Address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Address of store: " + Address);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the services of 8th store
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All Services of 8th store: " + services);
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get storeservices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<String> storeServices = response.extract().path("data.services.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test011(){
        List<Integer> total = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeId: " + total);
        System.out.println("------------------End of Test---------------------------");
    }
    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> allStoreID=response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeId: " + allStoreID);
        System.out.println("------------------End of Test---------------------------");
    }
    //13. Find the store names Where state = ND
    @Test
    public void test013(){
        List<String> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }
    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014(){
        List<String> numOfServices = response.extract().path("data.findAll{it.name=='Rochester'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All storeservices: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015() {
        List<String> numOfServices = response.extract().path("data.findAll{it.services=='Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016() {
        List<String> numOfServices = response.extract().path("data.findAll{it.name=='Fargo'}.services");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //17. Find the zip of all the store
    @Test
    public void test017(){
        List<Integer> numOfServices = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test018() {
        List<Integer> numOfServices = response.extract().path("data.findAll{it.name=='Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019() {
        List<?> numOfServiceId = response.extract().path("data.findAll{it.name =='Magnolia Home Theater'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServiceId);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test020(){
        List<Integer> numOfServices = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All services: " + numOfServices);
        System.out.println("------------------End of Test---------------------------");
    }
}
