package org.example.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService {
    private List<Vehicle> list;
    private List<Car> carList;
    private List<Train> trainList;

    public VehicleService(List<Vehicle> list) {
        this.list = list;
        this.carList = getCars();
        this.trainList = getTrains();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Train> getTrainList() {
        return trainList;
    }

    public List<Vehicle> getVehicleList() {
        return list;
    }

    public void setList(List<Vehicle> list) {
        this.list = list;
    }

    public List<Car> getCars() {
        List<Car> res = new ArrayList<>();
        for (Vehicle v : getVehicleList()) {
            if ("carClass".equals(v.getType())) {
                res.add((Car) v);
            }
        }
        return res;
    }

    public List<Train> getTrains() {
        List<Train> res = new ArrayList<>();
        for (Vehicle v : getVehicleList()) {
            if ("trainClass".equals(v.getType())) {
                res.add((Train) v);
            }
        }
        return res;
    }


    public List<Vehicle> getListByType(String type) {
        List<Vehicle> res = new ArrayList<>();
        for (Vehicle v : getVehicleList()) {
            if (type.equals(v.getType())) {
                res.add(v);
            }
        }
        return res;
    }

    public List<Vehicle> getListByModel(String model) {
        List<Vehicle> res = new ArrayList<>();
        for (Vehicle v : getVehicleList()) {
            if (model.equals(v.getModel())) {
                res.add(v);
            }
        }
        return res;
    }

    public List<Vehicle> getListByMark(String mark) {
        return getVehicleList().stream().filter(vehicle -> mark == (vehicle.getMark())).collect(Collectors.toList());
    }

    public List<Car> getListCarsByEngineSize(double engineSize) {
        return getCarList().stream().filter(car -> engineSize == car.getEngineSize()).collect(Collectors.toList());
    }

    public List<Train> getListTrainsByEngineSize(double engineSize) {
        return getTrainList().stream().filter(train -> engineSize == train.getEngineSize()).collect(Collectors.toList());
    }
}
