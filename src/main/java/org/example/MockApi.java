package org.example;

public class MockApi {
    private final String endpoint;
    public MockApi(String endpoint) {
        this.endpoint = endpoint;
    }

    public String fetchWeather() {
        System.out.println("Fetching data from endpoint " + endpoint + "...");
        return "{weather: { city: \"Bardejov\", temp: 34, type: \"Sunny\"}}";
    }
}
