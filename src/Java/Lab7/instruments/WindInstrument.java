package Java.Lab7.instruments;

import Java.Lab7.enums.AirDirection;

import java.util.Scanner;

public class WindInstrument extends Instrument {

    private String bodyMaterial;
    private AirDirection airDirection; //(Прямое, поперечное)

    public WindInstrument() {
        super();
//        this.airDirection = airDirection;
//        this.bodyMaterial = bodyMaterial;
    }


    public void set(Scanner scanner) {
        super.set(scanner);
        System.out.println("Опишите духовой инструмент: ");

//        System.out.println("Введите название бренда");
//        this.setBrand(scanner.next());
//
//        System.out.println("Введите название инструмента");
//        this.setName(scanner.next());

        System.out.println("Введите материал инструмента");
        this.bodyMaterial = scanner.next();

        System.out.println("Введите направление воздуха");
        this.airDirection = AirDirection.valueOf(scanner.next());

//        return inst;
    }

    public void changeAirDirection(AirDirection newDirection) {
        System.out.println(getName() + " меняет направление воздуха с " + airDirection + " на " + newDirection);
        this.airDirection = newDirection;
    }


    @Override
    public void play() {
        System.out.println("Дуем в инструмент " + getName());
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public AirDirection getAirDirection() {
        return airDirection;
    }

    public void setAirDirection(AirDirection airDirection) {
        this.airDirection = airDirection;
    }

    @Override
    public String toString() {
        return "WindInstrument{" +
                "bodyMaterial='" + bodyMaterial + '\'' +
                ", airDirection=" + airDirection +
                "} " + super.toString();
    }
}
