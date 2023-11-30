package org.example.lab3;

import java.util.ArrayList;
import java.util.List;

public class VehicleServiceWithoutStreamApi implements VehicleServiceIntarface {
    private List<Vehicle> list;
    private List<Car> carList;
    private List<Train> trainList;

    public VehicleServiceWithoutStreamApi(List<Vehicle> list) {
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
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : getVehicleList()) {
            if (mark.equals(vehicle.getMark())) {
                result.add(vehicle);
            }
        }
        return result;
    }

    public List<Car> getListCarsByEngineSize(double engineSize) {
        List<Car> result = new ArrayList<>();
        for (Car car : getCarList()) {
            if (engineSize == car.getEngineSize()) {
                result.add(car);
            }
        }
        return result;
    }

    public List<Train> getListTrainsByEngineSize(double engineSize) {
        List<Train> result = new ArrayList<>();
        for (Train train : getTrainList()) {
            if (engineSize == train.getEngineSize()) {
                result.add(train);
            }
        }
        return result;
    }
}
