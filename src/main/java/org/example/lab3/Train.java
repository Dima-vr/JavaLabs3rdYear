package org.example.lab3;

import java.util.Objects;

public class Train extends Vehicle implements Comparable<Train> {
    private double engineSize;
    private int countWagons;

    public Train(TrainBuilder tb) {
        super(tb);
        this.engineSize = tb.engineSize;
        this.countWagons = tb.countWagons;
        this.type = "trainClass";
    }

    public Train(String mark, String model, String type, int engineSize, int countWagons) {
        super(mark, model, type);
        this.engineSize = engineSize;
        this.countWagons = countWagons;
    }

    public Train() {
    }

    public double getEngineSize() {
        return engineSize;
    }

    public int getCountWagons() {
        return countWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Train)) return false;
        if (!super.equals(o)) return false;
        Train train = (Train) o;
        return engineSize == train.engineSize && countWagons == train.countWagons;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), engineSize, countWagons);
    }

    @Override
    public String toString() {
        return "Train{" +
                "engineSize=" + engineSize +
                ", countWagons=" + countWagons +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public int compareTo(Train o) {
        return this.countWagons - o.countWagons;
    }

    public static class TrainBuilder extends VehicleBuilder {
        private double engineSize;
        private int countWagons;

        public TrainBuilder setEngineSize(double engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        public TrainBuilder setCountWagons(int countWagons) {
            this.countWagons = countWagons;
            return this;
        }

        @Override
        public Vehicle build() {
            return new Train(this);
        }
    }
}
