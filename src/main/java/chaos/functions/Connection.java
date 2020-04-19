package com.chaos.functions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.net.URL;

public class Connection {

    /**
     * Establishes an http connect ion to envoy in order to request endpoints.
     * @param envoyURL api endpoint
     * @param action specifies the request method (GET,POST,PUT,etc.).
     * @return
     */
    public static String doHttpURLConnectionAction(String envoyURL, String action) throws MalformedURLException, IOException{
        URL url = null;
        BufferedReader reader = null;
        StringBuilder stringBuilder;
        String responseMessage = "";

        try {
            // create the HttpURLConnection
            url = new URL(envoyURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // set the HTTP request method here
            conn.setRequestMethod(action);

            // conn.setRequestProperty("", "");

            System.out.println("Request Method " + conn.getRequestMethod());

            // give envoy admin server 15 seconds to respond
            conn.setReadTimeout(15*1000);
            conn.connect();

            // read the output from the server
            responseMessage = conn.getResponseMessage();
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            System.out.println(stringBuilder.toString());

            System.out.println("Status Code: " + conn.getResponseCode());

        } catch (MalformedURLException error) {
            // output expected MalformedURLExceptions.
            Logging.log(error);
            // throw new AssertionError(error);
        } catch (Exception exception) {
            // output unexpected Exceptions.
            Logging.log(exception, false);
        }
        return responseMessage;
    }
}