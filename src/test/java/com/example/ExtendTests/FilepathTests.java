package com.example.ExtendTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest(properties = {"dataFilePath=src/main/resources/sample-resource.txt"})
class FilepathTests extends TestBaseClass{

    @BeforeEach
    public void setUp() {
        try {
            File file = new File(dataFilePath);
            URI uri = file.toURI();
            Path path = Paths.get(uri);
            byte[] fileBytes = Files.readAllBytes(path);
            resourceFileContents = new String(fileBytes);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    @Test
    void specificFilepathTest() {
        System.err.println("FilepathTests specificTest");
        assert(!resourceFileContents.isEmpty());
    }
}
