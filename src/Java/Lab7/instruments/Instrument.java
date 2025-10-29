package Java.Lab7.instruments;

import java.util.Objects;
import java.util.Scanner;

public abstract class Instrument {

    private String brand;
    private String name;

    public Instrument(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public abstract void play();

    public abstract void edit(Scanner scanner);

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

    @Override
    public String toString() {
        return "Instrument{" +
                "brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Instrument that = (Instrument) o;
        return Objects.equals(brand, that.brand) && Objects.equals(name, that.name);
    }
}
