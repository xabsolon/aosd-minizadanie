package org.example;

import java.util.HashMap;
import java.util.Map;

public class CarSearchServiceProxy implements CarSearchService {
    private CarSearchService carSearchService;
    private Map<String, Car> cache;

    public CarSearchServiceProxy(CarSearchService carSearchService) {
        this.carSearchService = carSearchService;
        this.cache = new HashMap<>();
    }

    @Override
    public Car searchCar(String model) {
        if (cache.containsKey(model)) {
            // Return from cache
            return cache.get(model);
        } else {
            Car car = carSearchService.searchCar(model);
            // Add to cache
            cache.put(model, car);
            return car;
        }
    }
}
