package com.example;

// import java.io.ByteArrayInputStream;
// import java.io.IOException;
// import java.io.InputStream;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        LocationApiClient locationApiClient = new LocationApiClient();
        locationApiClient.setApiKey("");
        locationApiClient.setApiUrl("Zielona_Gora");
        locationApiClient.fetchLocationData();
        System.out.println(locationApiClient.data);
        String y = locationApiClient.data.get(0).get("lat").toString();
        System.out.println(y);
        
        WeatherApiClient weatherApiClient = new WeatherApiClient();
        weatherApiClient.setApiKey("");
        weatherApiClient.setApiUrl(locationApiClient.data.get(0).get("lat").toString(), locationApiClient.data.get(0).get("lon").toString());
        // WeatherApiClient.setApiUrl();
        weatherApiClient.fetchWeatherData();
        
        
        System.out.println(weatherApiClient.data);
        // float x;
        double x= weatherApiClient.data.get("current").get("weather").asDouble();
        System.out.println(x);
        System.out.println(weatherApiClient.data.get("current").get("weather").get(0).get("main"));
        weatherApiClient.setTemp(weatherApiClient.data.get("current").get("temp").asDouble());
        System.out.println(weatherApiClient.temp);

        // x=x-270.15;
        // System.out.println(x);


        


                // // Convert the modified JSON back to a string
                // String updatedJsonString = mapper.writeValueAsString(rootNode);
                // System.out.println("Modified JSON: " + updatedJsonString);
    }
}