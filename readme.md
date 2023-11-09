# Cache implementation in AspectJ and cuckoo's egg design pattern

## Cache aspect


In aspect CacheMethodAspect.aj we are using the around() advice
that checks if a requested value is present in the cache.
If it's present it's returned directly instead of calling proceed(), avoiding redundant
computations. If it is not present in the cache, the method proceeds
with its normal execution, and the result
is then saved in the cache for future use. This aspect can be applied to any method that returns String.
This can be specified in the method pointcut. We are using the function name as a key. The key is obtained from the function thisJoinPointStaticPart.getSignature().toShortString();

## Cache swap aspect (Cuckoo's egg)

The other aspect CacheSwapAspect.aj uses Cuckoo's egg design pattern. It checks whether the connection to the cache is successful when a cache is created.
If it's not successful the Cache object is swapped for BackupCache() which extends from the Cache() class.

We can use this sample code to check if the code is working. We have put println to every function:

```
        MockApi api = new MockApi("https://api.openweathermap.org/data/2.5/weather");
        String result = api.fetchWeather();
        String resultCached = api.fetchWeather();
        System.out.println("Result: " + result);
        System.out.println("Result cached: " + resultCached);
```

This code will print this output:

```
Fetching data from endpoint https://api.openweathermap.org/data/2.5/weather...
Saving value {weather: { city: "Bardejov", temp: 34, type: "Sunny"}} to cache.
Using normal cache to save value.
Value found in cache for MockApi.fetchWeather().
Using normal cache to get value.
Result: {weather: { city: "Bardejov", temp: 34, type: "Sunny"}}
Result cached: {weather: { city: "Bardejov", temp: 34, type: "Sunny"}}
```

We can see that the code uses normal cache because it's connection was successful.

Now we go to file CacheMethodAspect.aj and change the cache url to a one that is not working:

```
public aspect CacheMethodAspect {
    // Changed URL here
    private final Cache cache = new Cache("https://not-working-cache-1.com");

    ...
    
    String around() : method() {
        ...
    }
}
```

We run the code again and check the output:

```
Fetching data from endpoint https://api.openweathermap.org/data/2.5/weather...
Saving value {weather: { city: "Bardejov", temp: 34, type: "Sunny"}} to cache.
Using backup cache to save value.
Value found in cache for MockApi.fetchWeather().
Using backup cache to get value.
Result: {weather: { city: "Bardejov", temp: 34, type: "Sunny"}}
Result cached: {weather: { city: "Bardejov", temp: 34, type: "Sunny"}}
```

We can see that now the program uses backup cache because it couldn't connect to the normal cache.
In the program we aren't actually connecting to the HTTP endpoint. It's only simulated and data are mocked.








Name: Michael Absolon
Subject: Aspect-oriented software development