package com.sebastian.boot2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cat {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Cat() {
    }

    public Cat(final String name) {
        this.name = name;
    }
}