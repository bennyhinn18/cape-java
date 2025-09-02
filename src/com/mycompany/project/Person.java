package com.mycompany.project;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name);
    }
}
