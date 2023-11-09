package org.example;

public aspect CacheMethodAspect {
    private final Cache cache = new Cache("https://not-working-cache-1.com");

    pointcut method() : call(* org.example.MockApi.fetchWeather(..));

    String around() : method() {

        String functionName = thisJoinPointStaticPart.getSignature().toShortString();

        if (cache.containsKey(functionName)) {
            System.out.println("Value found in cache for " + functionName + ".");
            return cache.get(functionName);
        } else {
            String val = proceed();
            System.out.println("Saving value " + val + " to cache.");
            cache.put(functionName, val);
            return val;
        }
    }
}
