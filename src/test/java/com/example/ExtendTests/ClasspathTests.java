package com.example.ExtendTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@SpringBootTest(properties = {"dataFilePath=sample-resource.txt"})
class ClasspathTests extends TestBaseClass {

    @BeforeEach
    public void setUp() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dataFilePath)) {
            if (inputStream == null) {
                System.err.println("Resource not found: " + dataFilePath);
                return;
            }
            resourceFileContents = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("Error loading file: " + e.getMessage());
        }
    }

    @Test
    public void specificClasspathTest() {
        System.err.println("ClasspathTests specificTest");
        assert(!resourceFileContents.isEmpty());
    }
}
