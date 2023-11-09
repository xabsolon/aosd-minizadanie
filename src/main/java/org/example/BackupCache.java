package org.example;

public class BackupCache extends Cache {

    public BackupCache() {
        super("https://reddis-backup-cache.com");
    }

    @Override
    public String get(String key) {
        System.out.println("Using backup cache to get value.");
        return cache.get(key);
    }

    @Override
    public void put(String key, String value) {
        System.out.println("Using backup cache to save value.");
        cache.put(key, value);
    }
}
