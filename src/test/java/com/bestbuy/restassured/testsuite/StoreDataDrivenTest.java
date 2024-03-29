package com.bestbuy.restassured.testsuite;

import com.bestbuy.restassured.bestbuyinfo.StoreSteps;
import com.bestbuy.restassured.model.StorePojo;
import com.bestbuy.restassured.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

@Concurrent(threads = "2x")
@UseTestDataFrom("src/test/java/resources/testdata/storeinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
public class StoreDataDrivenTest extends TestBase {
    private String name;
    private String type;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private int lat;
    private int lng;
    private String hours;

   private StorePojo.Services services;


    @Steps
    StoreSteps storeSteps;
    @Title("Data driven test for adding multiple store to the application")
    @Test
    public void test001() {
        storeSteps.createStore(name, type, address,address2, city, state, zip, lat, lng, hours,services).statusCode(201);
    }
}
