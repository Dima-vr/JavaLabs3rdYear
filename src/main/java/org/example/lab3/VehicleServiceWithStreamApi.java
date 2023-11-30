package org.example.lab3;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VehicleServiceWithStreamApi implements VehicleServiceIntarface {
    private List<Vehicle> list;
    private List<Car> carList;
    private List<Train> trainList;

    public VehicleServiceWithStreamApi(List<Vehicle> list) {
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
        return getVehicleList().stream()
                .filter(isCar())
                .map(v -> (Car) v)
                .collect(Collectors.toList());
    }

    public List<Train> getTrains() {
        return getVehicleList().stream()
                .filter(isTrain())
                .map(v -> (Train) v)
                .collect(Collectors.toList());
    }

    public List<Vehicle> getListByType(String type) {
        return getVehicleList().stream()
                .filter(isType(type))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getListByModel(String model) {
        return getVehicleList().stream()
                .filter(isModel(model))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getListByMark(String mark) {
        return getVehicleList().stream()
                .filter(isMark(mark))
                .collect(Collectors.toList());
    }

    public List<Car> getListCarsByEngineSize(double engineSize) {
        return getCarList().stream()
                .filter(isEngineSize(engineSize))
                .collect(Collectors.toList());
    }

    public List<Train> getListTrainsByEngineSize(double engineSize) {
        return getTrainList().stream()
                .filter(isEngineSize(engineSize))
                .collect(Collectors.toList());
    }

    // Predicates
    private Predicate<Vehicle> isCar() {
        return v -> "carClass".equals(v.getType());
    }

    private Predicate<Vehicle> isTrain() {
        return v -> "trainClass".equals(v.getType());
    }

    private Predicate<Vehicle> isType(String type) {
        return v -> type.equals(v.getType());
    }

    private Predicate<Vehicle> isModel(String model) {
        return v -> model.equals(v.getModel());
    }

    private Predicate<Vehicle> isMark(String mark) {
        return v -> mark.equals(v.getMark());
    }

    private Predicate<Vehicle> isEngineSize(double engineSize) {
        return v -> v instanceof Car && engineSize == ((Car) v).getEngineSize()
                || v instanceof Train && engineSize == ((Train) v).getEngineSize();
    }
}
