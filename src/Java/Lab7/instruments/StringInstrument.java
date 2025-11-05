package Java.Lab7.instruments;

import Java.Lab7.enums.PlayStyle;

import java.util.Scanner;

public class StringInstrument extends Instrument {

    private int numberOfStrings;
    private PlayStyle playStyle;

    public StringInstrument() {
        super();
//        this.numberOfStrings = numberOfStrings;
//        this.playStyle = playStyle;
    }

    public void set(Scanner scanner) {
        super.set(scanner);
        System.out.println("Опишите струнный инструмент: ");

//        System.out.println("Введите название бренда")   ;
//        this.setBrand(scanner.next());
//
//        System.out.println("Введите название инструмента");
//        this.setName(scanner.next());

        System.out.println("Введите кол-во струн");
        this.numberOfStrings = scanner.nextInt();

        System.out.println("Введите стиль игры");
        this.playStyle = PlayStyle.valueOf(scanner.next());


    }

    public void pluckString(int stringNumber) {
        if (stringNumber <= 0 || stringNumber > numberOfStrings) {
            System.out.println("Струна " + stringNumber + " отсутствует на инструменте " + getName());
        } else {
            System.out.println("Играем на струне " + stringNumber + " инструмента " + getName());
        }
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
