package org.example.lab2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SerializeToXml implements Serialize<Vehicle> {
    @Override
    public void writeToFile(List<Vehicle> objs, String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(new File(fileName), objs);
    }

    @Override
    public List<Vehicle> readFromFile(String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<Vehicle>>() {
        });
    }
}
