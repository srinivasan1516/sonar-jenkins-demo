package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void greetShouldWork() {
        assertEquals("Hello, SonarQube!", App.greet("SonarQube"));
    }

    @Test
    void greetShouldHandleBlank() {
        assertEquals("Hello, World!", App.greet(" "));
    }
}