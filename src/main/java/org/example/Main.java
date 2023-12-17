package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarSearchService carSearchService = new CarSearchServiceProxy(new CarSearchServiceImplementation());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter car model to search (or 'exit' to quit): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            Car car = carSearchService.searchCar(input);
            System.out.println("Found: " + car);
        }
    }
}