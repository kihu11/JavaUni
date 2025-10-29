package Java.Lab7;

import Java.Lab7.instruments.Instrument;
import Java.Lab7.instruments.PercussionInstrument;
import Java.Lab7.instruments.StringInstrument;
import Java.Lab7.instruments.WindInstrument;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Task {

    private static final int MAX_NUMBER = 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Instrument[] instruments = new Instrument[MAX_NUMBER];

        int count = 0;

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. Добавить инструмент\n" +
                            "2. Сыграть на инструментах\n" +
                            "3. Вывести информацию\n" +
                            "4. Отредактировать информацию\n" +
                            "5. Сравнить инструменты"
            );

            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {

                case 1 -> {
                    if (count > MAX_NUMBER) {
                        System.out.println("Нет места");
                    } else {
                        System.out.println("Введите какой тип инструмента 1-ударный, 2-струнный, 3-духовой");

                        int type = scanner.nextInt();

                        switch (type) {
                            case 1 -> instruments[count++] = PercussionInstrument.set(scanner);
                            case 2 -> instruments[count++] = StringInstrument.set(scanner);
                            case 3 -> instruments[count++] = WindInstrument.set(scanner);
                        }
                    }
                }

                case 2 -> {
                    for (int i = 0; i < instruments.length; i++) {
                        if (instruments[i] != null) {
                            instruments[i].play();
                        }
                    }
                }

                case 3 -> {
                    for (int i = 0; i < instruments.length; i++) {
                        if (instruments[i] != null) {
                            System.out.println(instruments[i]);
                        }
                    }
                }

                case 4 -> {
                    System.out.println("Введите индекс инструмента для редакции(0-4)");

                    int i1 = scanner.nextInt();

                    if (i1 < 0 || i1 > MAX_NUMBER) {
                        System.out.println("Введено неверно значение");
                    } else {
                        instruments[i1].edit(scanner);
                    }
                }

                case 5 -> {
                    System.out.println("Введите индексы инструменторв для сравнения(0-4)");

                    int i1 = scanner.nextInt();
                    int i2 = scanner.nextInt();

                    if (instruments[i1] == null || instruments[i2] == null) {
                        System.out.println("Один из инструментов отсутсвует ");
                    } else {
                        System.out.println("Равность: " + instruments[i1].equals(instruments[i2]));
                    }
                }
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}
//20