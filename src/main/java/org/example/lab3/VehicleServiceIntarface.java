package org.example.lab3;

import java.util.List;

public interface VehicleServiceIntarface {
    List<Vehicle> getVehicleList();
    List<Car> getCarList();
    List<Train> getTrainList();
    void setList(List<Vehicle> list);

    List<Car> getCars();
    List<Train> getTrains();

    List<Vehicle> getListByType(String type);
    List<Vehicle> getListByModel(String model);
    List<Vehicle> getListByMark(String mark);

    List<Car> getListCarsByEngineSize(double engineSize);
    List<Train> getListTrainsByEngineSize(double engineSize);


}
