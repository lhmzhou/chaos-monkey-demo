package com.chaos.functions;

public class RuntimeConfig {

    private static String ADDRESS = "http://131.0.0.1:9901";

    /**
     * Method modifies runtime configuration of the request method POST
     * and endpoint /runtime_modify?key1=value1&key2=value2&keyN=valueN
     */
    public static void modifyRuntimeConfig(String runtimeConfig){
        String envoyURL = ADDRESS + "/runtime_modify?";
        envoyURL = envoyURL + runtimeConfig;
        System.out.println(Connection.doHttpURLConnectionAction(envoyURL, "POST"));
    }

    /**
     * Get Runtime configurations via GET request on the runtime endpoint
     */
    public static void getRuntimeConfig(){
        String envoyURL = ADDRESS + "/runtime";
        Connection.doHttpURLConnectionAction(envoyURL, "GET");
    }

} 