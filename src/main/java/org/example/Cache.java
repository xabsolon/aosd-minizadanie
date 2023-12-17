package org.example;

import java.util.HashMap;
import java.util.Objects;

public class Cache{
    protected final HashMap<String, Object> cache = new HashMap<>();
    private final boolean isConnected;

    public Cache() {
        if ("endpoint" == "https://working-reddis-cache-1.com") {
            isConnected = true;
        } else {
            isConnected = false;
        }
    }

    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    public Object get(String key) {
        System.out.println("Using normal cache to get value.");
        return cache.get(key);
    }

    public void put(String key, Object value) {
        System.out.println("Using normal cache to save value.");
        cache.put(key, value);
    }

    public boolean isConnected() {
        return this.isConnected;
    }
}
