package org.example.lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


public class Car extends Vehicle implements Comparable<Car> {
    private int wheels;
    private double engineSize;
    private LocalDate dateOfRelease;

    public Car(CarBuilder cb) {
        super(cb);
        this.wheels = cb.wheels;
        this.engineSize = cb.engineSize;
        this.type = "carClass";
        this.dateOfRelease = cb.dateOfRelease;
    }

    public Car(String mark, String model, String type, LocalDate dateOfRelease, int wheels, double engineSize) {
        super(mark, model, type, dateOfRelease);
        this.wheels = wheels;
        this.engineSize = engineSize;
        this.dateOfRelease = dateOfRelease;
    }

    public Car() {
    }

    public int getWheels() {
        return wheels;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
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
                ", dateOfRelease=" + dateOfRelease +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        return this.wheels - o.wheels;
    }

    public static class CarBuilder extends VehicleBuilder {
        @NotNull
        @Min(value = 4, message = "min wheels = 4")
        public int wheels;
        @NotNull
        @Min(value = 1, message = "min engineSize = 1")
        public double engineSize;

        public CarBuilder setWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public CarBuilder setEngineSize(double engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        @Override
        public Car build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<CarBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if (constraintViolations.size() > 0) throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Car(this);
        }
    }
}
