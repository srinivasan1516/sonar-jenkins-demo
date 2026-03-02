package com.example;

public class App {
    public static void main(String[] args) {
        System.out.println(greet("SonarQube"));
    }

    public static String greet(String name) {
        if (name == null || name.isBlank()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }
}