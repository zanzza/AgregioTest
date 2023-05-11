package com.agregio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parc parc = (Parc) o;
        return megawatt == parc.megawatt && Objects.equals(id, parc.id) && Objects.equals(name, parc.name) && type == parc.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, megawatt, type);
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
