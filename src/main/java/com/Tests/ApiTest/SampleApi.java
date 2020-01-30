package com.Tests.ApiTest;

import com.DataObjects.SampleObject;
import com.Utilities.DataLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Test(groups = "authTestSuit")
public class SampleApi extends BaseConfiguration {

    @Test(dataProvider="userTestDataProvider")
    public void authTest(final JSONArray testData){
        DataLoader dataLoader=new DataLoader(testData);
        Response response=helper.sendApiRequest(dataLoader.getMethod(),dataLoader.getUrl(),dataLoader.getPayload(),null);
        dataPool.setAccessToken(response.path("token"));
    }

    @Test(dataProvider="userTestDataProvider")
    public void usertest(final JSONArray testData){
        DataLoader dataLoader=new DataLoader(testData);
        try {
            File file = new File("src/main/resources/ApiTestData/pojoTest.json");
            String json = Files.readFile(file);
            JsonParser jsonParser=new JsonParser();
            JsonArray jb= (JsonArray) jsonParser.parse(json);
            Gson gson = new Gson();
            //List<SampleObject> datalist=new ArrayList<>();
            List<LinkedTreeMap<String,String>> datajson=gson.fromJson(jb,List.class);
            Stream<LinkedTreeMap<String, String>> filter= datajson.stream().filter(item->item.get("id").contains("143"));

            datajson.forEach(test->{
                System.out.println(test);
                //String.Concat("fadf","fdsf")
            });
            SampleObject address=gson.fromJson(jb, SampleObject.class);

        }catch (Exception e){}

    }
}
