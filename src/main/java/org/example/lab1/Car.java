package org.example.lab1;

import java.util.Objects;

/**
 * The type Car.
 */
public class Car extends Vehicle {
    private final int wheels;
    private final double engineSize;

    /**
     * Instantiates a new Car.
     *
     * @param cb the cb
     */
    public Car(CarBuilder cb) {
        super(cb);
        this.wheels = cb.wheels;
        this.engineSize = cb.engineSize;
    }

    /**
     * Gets wheels.
     *
     * @return the wheels
     */
    public int getWheels() {
        return wheels;
    }

    /**
     * Gets engine size.
     *
     * @return the engine size
     */
    public double getEngineSize() {
        return engineSize;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return wheels == car.wheels && Double.compare(car.engineSize, engineSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wheels, engineSize);
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                ", engineSize=" + engineSize +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    /**
     * The type Car builder.
     */
    public static class CarBuilder extends VehicleBuilder {
        /**
         * The Wheels.
         */
        public int wheels;
        /**
         * The Engine size.
         */
        public double engineSize;

        /**
         * Sets wheels.
         *
         * @param wheels the wheels
         * @return the wheels
         */
        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        /**
         * Sets engine size.
         *
         * @param engineSize the engine size
         * @return the engine size
         */
        public CarBuilder setEngineSize(double engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        @Override
        public Car build() {
            return new Car(this);
        }
    }
}
