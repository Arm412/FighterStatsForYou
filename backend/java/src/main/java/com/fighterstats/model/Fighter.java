package com.fighterstats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String weightClass;

    public Fighter() {}

    public Fighter(String name, String weightClass) {
        this.name = name;
        this.weightClass = weightClass;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getWeightClass() { return weightClass; }
    public void setWeightClass(String weightClass) { this.weightClass = weightClass; }
}
