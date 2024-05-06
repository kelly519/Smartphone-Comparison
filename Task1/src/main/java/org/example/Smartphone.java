package org.example;

import java.io.Serializable;
import java.util.Objects;

public class Smartphone implements Serializable{
    private String brand;
    private String model;
    private double price;

    public Smartphone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Price: $" + price;
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Double.compare(that.price, price) == 0 &&
                brand.equals(that.brand) &&
                model.equals(that.model);
    }


    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price);
    }
}