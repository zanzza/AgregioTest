package com.agregio.entity;

import jakarta.persistence.*;

@Entity
public class Parc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int megawatt;

    private Type type;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMegawatt() {
        return megawatt;
    }

    public void setMegawatt(int megawatt) {
        this.megawatt = megawatt;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Parc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", megawatt=" + megawatt +
                ", type=" + type +
                '}';
    }
}
