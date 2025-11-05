package Java.Lab7.instruments;

import java.util.Objects;
import java.util.Scanner;

public abstract class Instrument {

    private String brand;
    private String name;

    //  private static int count = 0;

    public Instrument() {    }

//    public static int getCount() {
//        return count;
//    }

    public abstract void play();

    public void set(Scanner scanner){
        System.out.println("Введите название бренда")   ;
        this.setBrand(scanner.next());

        System.out.println("Введите название инструмента");
        this.setName(scanner.next());
    }


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
