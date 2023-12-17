package org.example;

public class CarSearchServiceImplementation implements CarSearchService {
    @Override
    public Car searchCar(String model) {
        // Simulate database search with a delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Car(model, "Example Make", 2020);
    }
}
