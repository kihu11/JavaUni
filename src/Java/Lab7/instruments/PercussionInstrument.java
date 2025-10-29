package Java.Lab7.instruments;

import java.util.Objects;
import java.util.Scanner;

public class PercussionInstrument extends Instrument {

    private boolean isTuned;
    private String material;

    public PercussionInstrument(String brand, String name, boolean isTuned, String material) {
        super(brand, name);
        this.isTuned = isTuned;
        this.material = material;
    }

    @Override
    public void edit(Scanner scanner) {
        System.out.println("Отредактируем ударный инструмент");

        System.out.println("Введите новую настрой инструмента");
        this.isTuned = parseYesNo(scanner.next());

        System.out.println("Введите материал ударного инструмента");
        this.material = scanner.next();
    }

    public static PercussionInstrument set(Scanner scanner) {
        System.out.println("Опишите ударный инструмент: ");
        PercussionInstrument inst = new PercussionInstrument(" ", " ", false, " ");

        System.out.println("Введите название бренда");
        inst.setBrand(scanner.next());

        System.out.println("Введите название инструмента");
        inst.setName(scanner.next());

        System.out.println("Введите настроен ли инструмент Да[y], Нет[n](Значение по умолчанию)");
        inst.setTuned(parseYesNo(scanner.next()));

        System.out.println("Введите материал инструмента");
        inst.material = scanner.next();

        return inst;
    }

    private static boolean parseYesNo(String input) {
        return input.equals("y");
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
