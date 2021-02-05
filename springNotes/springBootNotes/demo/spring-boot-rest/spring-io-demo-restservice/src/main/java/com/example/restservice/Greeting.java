package com.example.restservice;

import lombok.Data;

@Data
public class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        System.out.println("Greeting instance created");
        this.id = id;
        this.content = content;
    }
}
