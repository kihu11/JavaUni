package Java.Lab7.instruments;

import java.util.Objects;
import java.util.Scanner;

public class PercussionInstrument extends Instrument {

    private boolean isTuned;
    private String material;

    public PercussionInstrument() {
        super();
//        this.isTuned = isTuned;
//        this.material = material;
    }

 //   @Override
//    public void edit(Scanner scanner) {
//        System.out.println("Отредактируем ударный инструмент");
//
//        System.out.println("Введите новую настрой инструмента");
//        this.isTuned = parseYesNo(scanner.next());
//
//        System.out.println("Введите материал ударного инструмента");
//        this.material = scanner.next();
//    }

    @Override
    public void set(Scanner scanner) {
        super.set(scanner);
        System.out.println("Опишите ударного инструмента ");

        System.out.println("Введите настроен ли инструмент (y/n)");
        this.isTuned = parseYesNo(scanner.next());

        System.out.println("Введите материал ударного инструмента");
        this.material = scanner.next();
    }

    public void tune() {
        if (!isTuned) {
            System.out.println(getName() + " уже настроен");
            isTuned = true;
        } else {
            System.out.println(getName() + " настроили");
        }
    }


    private static boolean parseYesNo(String input) {
        return input.equals("Y");
    }

    @Override
    public void play() {
        System.out.println("Бьем в инструмент");
    }

    public boolean isTuned() {
        return isTuned;
    }

    public void setTuned(boolean tuned) {
        isTuned = tuned;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString() + ", PercussionInstrument{" +
                "isTuned=" + isTuned +
                ", material='" + material + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PercussionInstrument that = (PercussionInstrument) o;
        return isTuned == that.isTuned && Objects.equals(material, that.material);
    }
}
