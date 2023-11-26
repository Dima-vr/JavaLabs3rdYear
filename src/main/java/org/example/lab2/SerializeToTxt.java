package org.example.lab2;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToTxt implements Serialize<Car> {
    @Override
    public void writeToFile(List<Car> objs, String fileName) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema schema = mapper.schemaFor(Car.class).withHeader();
        ObjectWriter writer = mapper.writerFor(Car.class).with(schema);
        writer.writeValues(new File(fileName)).writeAll(objs);
    }

    @Override
    public List<Car> readFromFile(String fileName) throws IOException {
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema schema = mapper.schemaFor(Car.class).withHeader();
        ObjectReader reader = mapper.readerFor(Car.class).with(schema);
        return (List) reader.readValues(new File(fileName)).readAll();
    }
}
