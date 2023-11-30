package org.example.lab4;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        try {
            Car car = (Car) new Car.CarBuilder()
                    .setEngineSize(1)
                    .setWheels(4)
                    .setDateOfRelease(LocalDate.of(2004, 5, 6))
                    .setMark("Mazda")
                    .setModel("rx7")
                    .build();

            Train train = (Train) new Train.TrainBuilder()
                    .setCountWagons(12)
                    .setEngineSize(10)
                    .setMark("RailStar")
                    .setModel("500")
                    .setDateOfRelease(LocalDate.of(2004, 5, 6))
                    .build();

            Car car2 = (Car) new Car.CarBuilder()
                    .setWheels(4)
                    .setEngineSize(2.0)
                    .setMark("Škoda")
                    .setModel("Octavia")
                    .setDateOfRelease(LocalDate.of(2004, 5, 6))
                    .build();


            System.out.println(car);
            System.out.println(train);
            System.out.println(car2);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
