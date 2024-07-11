package model;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private LocalDate dob;
    private double height;
    private double weight;

    public Person(String name, LocalDate dob, double height, double weight) {
        this.name = name;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return ", name='" + name + '\'' +
                ", dob=" + dob +
                ", height=" + height +
                ", weight=" + weight;
    }
}
