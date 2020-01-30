package com.Utilities;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

public class ConfigParser {

    public Map<String, String> inputParam = new HashMap<>();
    public Map<String, String> testDataPath = new HashMap<>();
    public Config config= ConfigFactory.parseResources("applicationSetting.conf");

    private ConfigParser(){
        inputParam.put("baseUrl",config.getString("conf.baseUrl"));
        inputParam.put("username",config.getString("conf.username"));
        inputParam.put("password",config.getString("conf.password"));

        testDataPath.put("sampleApiTestData", config.getString("testData.SampleApiTestData"));

    }

    private static ConfigParser configParser;

    public static ConfigParser getConfigParser(){
        if(configParser ==null){
            configParser =new ConfigParser();
            return configParser;
        }
        else{
            return configParser;
        }
    }


}
