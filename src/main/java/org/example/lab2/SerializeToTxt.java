package org.example.lab2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeToTxt implements Serialize<Car> {
    private final ObjectMapper mapper;

    public SerializeToTxt() {
        mapper = new ObjectMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        mapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new ToStringSerializer());
        module.addDeserializer(LocalDate.class, LocalDateDeserializer.INSTANCE);
        mapper.registerModule(module);
    }

    @Override
    public void writeToFile(List<Car> cars, String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int totalCarsLength = cars.size();
        for (int i = 0; i < totalCarsLength; i++) {
            Car car = cars.get(i);
            String carString = String.format(
                    "Type: %s, Mark: %s, Model: %s, Wheels: %d, EngineSize: %s",
                    car.getType(), car.getMark(), car.getModel(),
                    car.getWheels(), car.getEngineSize()
            );
            if (i < totalCarsLength - 1) {
                carString += "\n";
            }
            stringBuilder.append(carString);
        }
        Files.write(Paths.get(fileName), stringBuilder.toString().getBytes());
    }

    @Override
    public List<Car> readFromFile(String fileName) throws IOException {
        List<Car> cars = new ArrayList<>();

        List<String> lines = Files.readAllLines(Path.of(fileName));

        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length >= 5) {
                String type = getValue(parts[0]);
                String mark = getValue(parts[1]);
                String model = getValue(parts[2]);
                int wheels = Integer.parseInt(getValue(parts[3]));
                double engineSize = Double.parseDouble(getValue(parts[4]));

                Car car = new Car(mark, model, type, wheels, engineSize);
                cars.add(car);
            }
        }

        return cars;
    }

    private String getValue(String part) {
        String[] keyValue = part.split(": ");
        return keyValue[1].trim();
    }

}