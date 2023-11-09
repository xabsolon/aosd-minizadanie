package org.example;

public aspect CacheSwapAspect {
    Cache around(): call(Cache.new(..)) && !within(BackupCache) {
        Cache cache = proceed();
        return !cache.isConnected() ? new BackupCache() : cache;
    }
}
