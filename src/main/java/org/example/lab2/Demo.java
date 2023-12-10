package org.example.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        cb2.setMark("Skoda");
        cb2.setModel("Octavia");
        cb2.setEngineSize(2.0);
        cb2.setWheels(4);

        Train train = (Train) tb.build();
        Car car1 = (Car) cb1.build();
        Car car2 = (Car) cb2.build();

        List<Vehicle> myList1 = new ArrayList<>();
        myList1.add(train);
        myList1.add(car1);
        myList1.add(car2);
        List<Car> myList2 = new ArrayList<>();
        myList2.add(car1);
        myList2.add(car2);

        SerializeToJSON serializerJSON = new SerializeToJSON();
        SerializeToXml serializerToXml = new SerializeToXml();
        SerializeToTxt serializerToTxt = new SerializeToTxt();


        System.out.println("json:");
        serializerJSON.writeToFile(myList1, "Vehicle.json");
        System.out.println(serializerJSON.readFromFile("Vehicle.json"));

        System.out.println("xml:");
        serializerToXml.writeToFile(myList1, "Vehicle.xml");
        System.out.println(serializerToXml.readFromFile("Vehicle.xml"));

        System.out.println("txt:");
        serializerToTxt.writeToFile(myList2, "Vehicle.txt");
        System.out.println(serializerToTxt.readFromFile("Vehicle.txt"));
    }
}
