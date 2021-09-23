package com.example.entity;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class book {

    @Id
    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
