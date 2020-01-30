package com.Utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class DataLoader {

    private String url;
    private String method;
    private String payload;
    private HashMap<String,String> testParameter;
    private String outputStatusCode;
    private String expectedResponse;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public HashMap<String, String> getTestParameter() {
        return testParameter;
    }

    public void setTestParameter(HashMap<String, String> testParameter) {
        this.testParameter = testParameter;
    }

    public String getOutputStatusCode() {
        return outputStatusCode;
    }

    public void setOutputStatusCode(String outputStatusCode) {
        this.outputStatusCode = outputStatusCode;
    }

    public String getExpectedResponse() {
        return expectedResponse;
    }

    public void setExpectedResponse(String expectedResponse) {
        this.expectedResponse = expectedResponse;
    }


    public DataLoader(JSONArray data){
        System.out.println(data);
        HashMap<String,String> inputData= new HashMap<>();
        HashMap<String,String> outputData= new HashMap<>();
        inputData= (HashMap<String, String>) ((JSONObject) data.get(0)).get("input");
        outputData= (HashMap<String, String>) ((JSONObject) data.get(0)).get("output");

        //InputFields
        setPayload(inputData.get("payload"));
        setMethod(inputData.get("method"));
        setUrl(inputData.get("URL"));
        //setTestParameter((HashMap<String,String>)(inputData.get("parameter")));
       //OutputFields
        setExpectedResponse(outputData.get("response"));
        setOutputStatusCode(outputData.get("statusCode"));
    }





}
