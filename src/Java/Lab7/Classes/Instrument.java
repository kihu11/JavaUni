package Java.Lab7.Classes;

import java.util.Scanner;

public abstract class Instrument {

    private String brand;
    private String name;

    public Instrument(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public abstract void play();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
