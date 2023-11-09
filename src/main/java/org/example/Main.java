package org.example;

public class Main {
    public static void main(String[] args) {
        MockApi api = new MockApi("https://api.openweathermap.org/data/2.5/weather");
        String result = api.fetchWeather();
        String resultCached = api.fetchWeather();
        System.out.println("Result: " + result);
        System.out.println("Result cached: " + resultCached);
    }
}