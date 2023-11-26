package org.example.lab4;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Car.CarBuilder cb1 = new Car.CarBuilder();
        Car.CarBuilder cb2 = new Car.CarBuilder();
        Train.TrainBuilder tb = new Train.TrainBuilder();
        cb1.setMark("Opel");
        cb1.setModel("Combo");
        cb1.setEngineSize(1.6);
        cb1.setWheels(4);

        tb.setMark("RailStar");
        tb.setModel("500");
        tb.setEngineSize(10);
        tb.setCountWagons(12);

        cb2.setMark("Škoda");
        cb2.setModel("Octavia");
        cb2.setEngineSize(2.0);
        cb2.setWheels(4);

        Train train = (Train) tb.build();
        Car car1 = (Car) cb1.build();
        Car car2 = (Car) cb2.build();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(train);
    }
}
