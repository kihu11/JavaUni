package Java.Lab7.instruments;

import Java.Lab7.enums.PlayStyle;

import java.util.Scanner;

public class StringInstrument extends Instrument {

    private int numberOfStrings;
    private PlayStyle playStyle;

    public StringInstrument(String brand, String name, int numberOfStrings, PlayStyle playStyle) {
        super(brand, name);
        this.numberOfStrings = numberOfStrings;
        this.playStyle = playStyle;
    }

    public void edit(Scanner scanner) {
        System.out.println("Отредактируем струнный инструмент");

        System.out.println("Введите новуе кол-во струн");
        this.numberOfStrings = scanner.nextInt();

        System.out.println("Введите новый стиль игры");
        this.setPlayStyle(PlayStyle.valueOf(scanner.next()));
    }

    public static StringInstrument set(Scanner scanner) {
        System.out.println("Опишите струнный инструмент: ");
        StringInstrument inst = new StringInstrument(" ", " ", 0, PlayStyle.PINCH);

        System.out.println("Введите кол-во струн");
        inst.numberOfStrings = scanner.nextInt();

        System.out.println("Введите стиль игры");
        inst.playStyle = PlayStyle.valueOf(scanner.next());

        return inst;
    }

    @Override
    public void play() {
        System.out.println("Играем " + getName() + " с помощью " + playStyle);
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public PlayStyle getPlayStyle() {
        return playStyle;
    }

    public void setPlayStyle(PlayStyle playStyle) {
        this.playStyle = playStyle;
    }

    @Override
    public String toString() {
        return "StringInstrument{" +
                "numberOfStrings=" + numberOfStrings +
                ", playStyle=" + playStyle +
                "} " + super.toString();
    }
}
