package org.example;

public class Car {
    private String model;
    private String make;
    private int year;

    public Car(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
