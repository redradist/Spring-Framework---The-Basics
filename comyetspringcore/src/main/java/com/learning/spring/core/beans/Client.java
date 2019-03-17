package com.learning.spring.core.beans;

public class Client {
    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    private String id;
    private String fullName;
}
