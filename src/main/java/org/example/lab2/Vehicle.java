package org.example.lab2;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "carClass"),
        @JsonSubTypes.Type(value = Train.class, name = "trainClass"),
        @JsonSubTypes.Type(value = Vehicle.class, name = "vehicleClass"),
})
abstract public class Vehicle {
    protected String mark;
    protected String model;
    protected String type;

    public Vehicle(VehicleBuilder vb) {
        this.mark = vb.mark;
        this.model = vb.model;
        this.type = this.getClass().getSimpleName().toLowerCase() + "Class";
    }

    public Vehicle(String mark, String model, String type) {
        this.mark = mark;
        this.model = model;
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(mark, vehicle.mark) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public static abstract class VehicleBuilder {
        protected String mark;
        protected String model;

        public VehicleBuilder setMark(String mark) {
            this.mark = mark;
            return this;
        }

        public VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        abstract public Vehicle build();
    }
}
