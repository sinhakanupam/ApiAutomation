package com.Tests.ApiTest;

import java.lang.reflect.Method;
import java.util.HashMap;

import com.Utilities.Helper;
import com.Utilities.DataPool;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.testng.*;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class BaseConfiguration {

    public final DataPool dataPool = DataPool.getDataPool();
    public final Helper helper=new Helper();

    @DataProvider(name="userTestDataProvider")
    public Object[][] userTestDataProvider(Method m){
        String testDataKey=this.getClass().getSimpleName()+"."+m.getName();
        JSONArray testJson = dataPool.getTestDataPool().get(testDataKey);
        return helper.testNgProvider(testJson);
    }

    @BeforeSuite
    public void loadData(){
        helper.loadTestData();
    }

    @AfterMethod
    public void createFailedCaseList(ITestResult test){
        if(test.getStatus()==ITestResult.FAILURE){
            //Code to add failed cases name



        }
    }
}
