package com.example.ExtendTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

abstract class TestBaseClass {

    @Value("${dataFilePath}")
    public String dataFilePath;

    public String resourceFileContents = "";

    @Test
    void baseClassTest() {
        System.err.println("TestBaseClass baseClassTest:"+resourceFileContents);
        assert(!resourceFileContents.isEmpty());
    }
}

