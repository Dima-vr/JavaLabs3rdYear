package org.example.lab1;

import java.util.Objects;

/**
 * The type Vehicle.
 */
abstract public class Vehicle {
    /**
     * The Mark.
     */
    protected final String mark;
    /**
     * The Model.
     */
    protected final String model;

    /**
     * Instantiates a new Vehicle.
     *
     * @param vb the vb
     */
    public Vehicle(VehicleBuilder vb) {
        this.mark = vb.mark;
        this.model = vb.model;
    }

    /**
     * Gets mark.
     *
     * @return the mark
     */
    public String getMark() {
        return mark;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
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

    /**
     * The type Vehicle builder.
     */
    public static abstract class VehicleBuilder {
        /**
         * The Mark.
         */
        protected String mark;
        /**
         * The Model.
         */
        protected String model;

        /**
         * Sets mark.
         *
         * @param mark the mark
         * @return the mark
         */
        public VehicleBuilder setMark(String mark) {
            this.mark = mark;
            return this;
        }

        /**
         * Sets model.
         *
         * @param model the model
         * @return the model
         */
        public VehicleBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        /**
         * Build vehicle.
         *
         * @return the vehicle
         */
        abstract public Vehicle build();
    }
}
