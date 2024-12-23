package com.example;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationApiClient extends ApiKey{
    protected String apiUrl;
    public JsonNode data;
    public void setApiUrl(String city){
        apiUrl = "http://api.openweathermap.org/geo/1.0/direct?q=" + city + "&limit=1&appid=" + apiKey;
    }
    
    public void fetchLocationData(){
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() == 200) {
                InputStream responseStream = connection.getInputStream();
                
                ObjectMapper mapper = new ObjectMapper();
                data = mapper.readTree(responseStream);
               
            
            } else {
                
                System.out.println("Failed to fetch data. HTTP Code: " + connection.getResponseCode());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
