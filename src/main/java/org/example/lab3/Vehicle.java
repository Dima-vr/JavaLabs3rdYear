package org.example.lab3;

import java.util.Objects;

import java.time.LocalDate;

abstract public class Vehicle {
    protected String mark;
    protected String model;
    protected String type;
    protected LocalDate dateOfRelease;

    public Vehicle(VehicleBuilder vb) {
        this.mark = vb.mark;
        this.model = vb.model;
        this.type = "vehicleClass";
        this.dateOfRelease = vb.dateOfRelease;
    }

    public Vehicle(String mark, String model, String type, LocalDate dateOfRelease) {
        this.mark = mark;
        this.model = model;
        this.type = type;
        this.dateOfRelease = dateOfRelease;
    }

    public Vehicle() {
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(mark, vehicle.mark) && Objects.equals(model, vehicle.model) && Objects.equals(dateOfRelease, vehicle.dateOfRelease);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model, dateOfRelease);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", dateOfRelease=" + dateOfRelease +
                '}';
    }

    public static abstract class VehicleBuilder {
        protected String mark;
        protected String model;
        protected LocalDate dateOfRelease;

        public VehicleBuilder setMark(String mark) {
            this.mark = mark;
            return this;
        }

        public VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public VehicleBuilder setDateOfRelease(LocalDate dateOfRelease) {
            this.dateOfRelease = dateOfRelease;
            return this;
        }

        abstract public Vehicle build();
    }
}

