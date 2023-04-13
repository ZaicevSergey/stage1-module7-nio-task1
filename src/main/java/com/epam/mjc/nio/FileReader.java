package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
            String line;
            Map<String, String> data = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split(": ");
                if (keyValue.length == 2) {
                    data.put(keyValue[0], keyValue[1]);
                }
            }
            String name = data.get("Name");
            Integer age = Integer.valueOf(data.get("Age"));
            String email = data.get("Email");
            Long phone = Long.valueOf(data.get("Phone"));
            return new Profile(name, age, email, phone);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
