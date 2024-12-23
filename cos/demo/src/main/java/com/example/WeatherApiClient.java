package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherApiClient extends ApiKey{
    protected String apiUrl;
    public JsonNode data;
    public double temp;
    protected void setApiUrl(String lat, String lon){
        apiUrl = "https://api.openweathermap.org/data/3.0/onecall?lat="+lat+"&lon="+lon+"&appid=" + apiKey;
    }
    public void fetchWeatherData(){
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
    public void setTemp(double temp){
        this.temp = temp;
    }
}
