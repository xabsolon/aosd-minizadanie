package org.example;

import java.util.HashMap;
import java.util.Objects;

public class Cache{
    protected final HashMap<String, String> cache = new HashMap<>();
    private final boolean isConnected;

    public Cache(String endpoint) {
        if (endpoint == "https://working-reddis-cache-1.com") {
            isConnected = true;
        } else {
            isConnected = false;
        }
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public String get(String key) {
        System.out.println("Using normal cache to get value.");
        return cache.get(key);
    }

    public void put(String key, String value) {
        System.out.println("Using normal cache to save value.");
        cache.put(key, value);
    }

    public boolean isConnected() {
        return this.isConnected;
    }
}
