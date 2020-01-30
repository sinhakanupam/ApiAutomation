package com.Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.*;

public class DataPool {


    private String accessToken;
    private static DataPool dataPool;
    private JSONObject testdata;

    public HashMap<Object, JSONArray> getTestDataPool() {
        return testDataPool;
    }

    public void setTestDataPool(HashMap<Object, JSONArray> testDataPool) {
        this.testDataPool = testDataPool;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    private HashMap<Object, JSONArray> testDataPool=new HashMap<>();

    public static DataPool getDataPool(){
        if(dataPool ==null){
            dataPool =new DataPool();
        }
        return dataPool;
    }

}
