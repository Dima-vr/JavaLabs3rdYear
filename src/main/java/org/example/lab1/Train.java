package org.example.lab1;

import java.util.Objects;

/**
 * The type Train.
 */
public class Train extends Vehicle {
    private final int engineSize;
    private final int countWagons;

    /**
     * Instantiates a new Train.
     *
     * @param tb the tb
     */
    public Train(TrainBuilder tb) {
        super(tb);
        this.engineSize = tb.engineSize;
        this.countWagons = tb.countWagons;
    }

    /**
     * Gets engine size.
     *
     * @return the engine size
     */
    public int getEngineSize() {
        return engineSize;
    }

    /**
     * Gets count wagons.
     *
     * @return the count wagons
     */
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

    /**
     * The type Train builder.
     */
    public static class TrainBuilder extends VehicleBuilder {
        private int engineSize;
        private int countWagons;

        /**
         * Sets engine size.
         *
         * @param engineSize the engine size
         * @return the engine size
         */
        public TrainBuilder setEngineSize(int engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        /**
         * Sets count wagons.
         *
         * @param countWagons the count wagons
         * @return the count wagons
         */
        public TrainBuilder setCountWagons(int countWagons) {
            this.countWagons = countWagons;
            return this;
        }

        @Override
        public Train build() {
            return new Train(this);
        }
    }
}
