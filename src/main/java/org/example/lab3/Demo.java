package org.example.lab3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Car.CarBuilder cb1 = new Car.CarBuilder();
        Car.CarBuilder cb2 = new Car.CarBuilder();
        Car.CarBuilder cb3 = new Car.CarBuilder();
        Train.TrainBuilder tb1 = new Train.TrainBuilder();
        Train.TrainBuilder tb2 = new Train.TrainBuilder();

        cb1.setMark("Opel");
        cb1.setModel("Combo");
        cb1.setEngineSize(1.6);
        cb1.setWheels(4);
        cb1.setDateOfRelease(LocalDate.of(2019, 5, 15));

        tb1.setMark("RailStar");
        tb1.setModel("500");
        tb1.setEngineSize(10);
        tb1.setCountWagons(12);
        tb1.setDateOfRelease(LocalDate.of(2020, 8, 10));

        tb2.setMark("DailRail");
        tb2.setModel("500");
        tb2.setEngineSize(10);
        tb2.setCountWagons(12);
        tb2.setDateOfRelease(LocalDate.of(2021, 3, 25));

        cb2.setMark("Škoda");
        cb2.setModel("Octavia");
        cb2.setEngineSize(2.0);
        cb2.setWheels(4);
        cb2.setDateOfRelease(LocalDate.of(2020, 6, 20));

        cb3.setMark("Opel");
        cb3.setModel("Astra");
        cb3.setEngineSize(2.0);
        cb3.setWheels(4);
        cb3.setDateOfRelease(LocalDate.of(2021, 1, 12));

        Train train1 = tb1.build();
        Train train2 = tb2.build();
        Car car1 = cb1.build();
        Car car2 = cb2.build();
        Car car3 = cb3.build();

        System.out.println("\nComparator example");
        List<Vehicle> vehicle = new ArrayList<>();
        vehicle.add(car1);
        vehicle.add(train1);
        vehicle.add(train2);
        vehicle.add(car2);
        vehicle.add(car3);
        vehicle.sort(new VehicleComparator());
        for (Vehicle v : vehicle) {
            System.out.println(v);
        }

        System.out.println("\nServices:");
//        VehicleServiceWithoutStreamApi vehicleService = new VehicleServiceWithoutStreamApi(vehicle);
        VehicleServiceWithStreamApi vehicleService = new VehicleServiceWithStreamApi(vehicle);


        System.out.println("\ngetListByType:");
        for (Vehicle c : vehicleService.getListByType("carClass")) {
            System.out.println(c);
        }

        System.out.println("\ngetListByMark:");
        for (Vehicle v : vehicleService.getListByMark("Opel")) {
            System.out.println(v);
        }

        System.out.println("\ngetListByModel:");
        for (Vehicle v : vehicleService.getListByModel("500")) {
            System.out.println(v);
        }

        System.out.println("\ngetListCarsByEngineSize:");
        for (Vehicle v : vehicleService.getListCarsByEngineSize(2)) {
            System.out.println(v);
        }

        System.out.println("\ngetListTrainsByEngineSize:");
        for (Vehicle v : vehicleService.getListTrainsByEngineSize(10)) {
            System.out.println(v);
        }
    }
}
