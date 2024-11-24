package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");

        Scanner scanner = new Scanner(System.in, "UTF-8");
        List<Car> cars = new ArrayList<>();

        System.out.println();

        System.out.print("Enter the number of cars: ");
        int numberOfCars = scanner.nextInt();
        scanner.nextLine();


        for (int i = 0; i < numberOfCars; i++) {
            System.out.println(); // Adding a blank line before data input for each new car
            System.out.println("Enter data for car " + (i + 1) + ":");

            // Input for car details with proper indentation
            System.out.print("  Brand: ");
            String brand = scanner.nextLine();

            System.out.print("  Car class: ");
            String carClass = scanner.nextLine();

            System.out.print("  Weight: ");
            double weight = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("  Driver's full name: ");
            String fullName = scanner.nextLine();

            System.out.print("  Driving experience (years): ");
            int experience = scanner.nextInt();
            scanner.nextLine();

            System.out.print("  Engine power: ");
            int power = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("  Engine manufacturer: ");
            String manufacturer = scanner.nextLine();

           
            Driver driver = new Driver(fullName, experience);
            Engine engine = new Engine(power, manufacturer);
            Car car = new Car(brand, carClass, weight, driver, engine);

            cars.add(car);
        }

        System.out.println();

        System.out.println("Drivers with more than 5 years of experience:");
        for (Car car : cars) {
            if (car.getDriver().getExperience() > 5) {
                System.out.println("  " + car.getDriver().getFullName());
            }
        }

        System.out.println();

        System.out.println("Soviet-made cars:");
        for (Car car : cars) {
            String brand = car.getBrand().trim().toLowerCase();
            if (brand.equals("gaz") ||
                brand.equals("moskvitsh") ||
                brand.equals("vaz") ||
                brand.equals("zaz") ||
                brand.equals("uaz") ||
                brand.equals("lada") ||
                brand.equals("chtz") ||
                brand.equals("tavria")) {

                System.out.println("  Brand: " + car.getBrand());
                System.out.println("  Class: " + car.getCarClass());
                System.out.println("  Weight: " + car.getWeight() + " kg");
                System.out.println("  Driver: " + car.getDriver().getFullName());
                System.out.println("  Driver's experience: " + car.getDriver().getExperience() + " years");
                System.out.println("  Engine power: " + car.getEngine().getPower() + " hp");
                System.out.println("  Engine manufacturer: " + car.getEngine().getManufacturer());
                System.out.println("  ------------------------------");
            }
        }

        scanner.close();
    }
}
