package org.example.lab1;

public class Demo {
    public static void main(String[] args) {
        Car.CarBuilder cb = new Car.CarBuilder();
        Train.TrainBuilder tb = new Train.TrainBuilder();
        cb.setMark("Opel");
        cb.setModel("Combo");
        cb.setEngineSize(1.6);
        cb.setWheels(4);

        tb.setMark("RailStar");
        tb.setModel("500");
        tb.setEngineSize(10);
        tb.setCountWagons(12);

        Car car = (Car) cb.build();
        Train train = (Train) tb.build();
        System.out.println(car);
        System.out.println(train);
    }
}
