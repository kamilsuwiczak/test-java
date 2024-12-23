package com.example;

public class WeatherData {
    private double temp;
    private double feelsLike;
    private double pressure;
    private double windSpeed;
    private double rain;


    public void setTemp(double temp){
        this.temp = temp;
    }
    public void setFeelsLikeTemp(double feelsLike){
        this.feelsLike = feelsLike;
    }
    public void setPressure(double pressure){
        this.pressure = pressure;
    }
    public void setWindSpeed(double windSpeed){
        this.windSpeed = windSpeed;
    }
    public void setRain(double rain){
        this.rain = rain;
    }

    public double getTemp(){
        return temp;
    }
    public double getFeelsLikeTemp(){
        return feelsLike;
    }
    public double pressure(){
        return pressure;
    }
    public double getWindSpeed(){
        return windSpeed;
    }
    public double getRain(){
        return rain;
    }


}
