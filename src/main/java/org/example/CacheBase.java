package org.example;

public abstract class CacheBase<C> extends Cache {

    public CacheBase() {
        super();
    }

    @Override
    public Object get(String key) {
        System.out.println("Using backup cache to get value.");
        return cache.get(key);
    }

    @Override
    public void put(String key, Object value) {
        System.out.println("Using backup cache to save value.");
        cache.put(key, value);
    }
}
