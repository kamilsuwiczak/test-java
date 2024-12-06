package com.example;

// import java.io.ByteArrayInputStream;
// import java.io.IOException;
// import java.io.InputStream;

// import com.fasterxml.jackson.databind.JsonNode;
// import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        ApiKey apiKey = new ApiKey();
        apiKey.setApiKey("d3b005518fed37afe862aef7abbb0403");
        WeatherApiClient WeatherApiClient = new WeatherApiClient();
        WeatherApiClient.setApiUrl(apiKey.getApiKey());
        // WeatherApiClient.setApiUrl();
        WeatherApiClient.fetchWeatherData();
        
        
        System.out.println(WeatherApiClient.data);
        // float x;
        double x= WeatherApiClient.data.get("current").get("temp").asDouble();
        System.out.println(x);
        x=x-270.15;
        System.out.println(x);
        


                // // Convert the modified JSON back to a string
                // String updatedJsonString = mapper.writeValueAsString(rootNode);
                // System.out.println("Modified JSON: " + updatedJsonString);
    }
}