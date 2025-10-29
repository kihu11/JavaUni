package Java.Lab7.instruments;

import Java.Lab7.enums.AirDirection;

import java.util.Scanner;

public class WindInstrument extends Instrument{

    private String bodyMaterial;
    private AirDirection airDirection; //(Прямое, поперечное)

    public WindInstrument(String brand, String name, AirDirection airDirection, String bodyMaterial) {
        super(brand, name);
        this.airDirection = airDirection;
        this.bodyMaterial = bodyMaterial;
    }

    public void edit(Scanner scanner) {
        System.out.println("Отредактируем духовой инструмент");

        System.out.println("Введите новуе материал инструмента");
        this.bodyMaterial = scanner.next();

        System.out.println("Введите направление воздуха");
        this.setAirDirection(AirDirection.valueOf(scanner.next()));
    }

    public static WindInstrument set(Scanner scanner) {
        System.out.println("Опишите духовой инструмент: ");
        WindInstrument inst = new WindInstrument(" ", " ", AirDirection.DIRECT, " ");

        System.out.println("Введите материал инструмента");
        inst.bodyMaterial = scanner.next();

        System.out.println("Введите направление воздуха");
        inst.airDirection = AirDirection.valueOf(scanner.next());

        return inst;
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
