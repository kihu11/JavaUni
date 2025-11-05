package Java.Lab7;
import Java.Lab7.enums.AirDirection;
import Java.Lab7.instruments.Instrument;
import Java.Lab7.instruments.PercussionInstrument;
import Java.Lab7.instruments.StringInstrument;
import Java.Lab7.instruments.WindInstrument;

import java.util.Scanner;

public class Task {

    private static final int MAX_NUMBER = 5;
    private static int count = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Instrument[] instruments = new Instrument[MAX_NUMBER];


        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. Добавить инструмент\n" +
                            "2. Сыграть на инструментах\n" +
                            "3. Вывести информацию\n" +
                            "4. Отредактировать информацию\n" +
                            "5. Сравнить инструменты\n" +
                            "6. Возможности инструмента"
            );

            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {

                case 1 -> {
                    if (count >= MAX_NUMBER) {
                        System.out.println("Нет места");
                    } else {
                        System.out.println("Введите тип инструмента (1-ударный, 2-струнный, 3-духовой):");
                        int type = scanner.nextInt();

                        Instrument inst = switch (type) {
                            case 1 -> new PercussionInstrument();
                            case 2 -> new StringInstrument();
                            case 3 -> new WindInstrument();
                            default -> null;
                        };

                        if (inst != null) {
                            inst.set(scanner);
                            instruments[count++] = inst;
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
                    System.out.print("Введите индекс инструмента (0-" + (count - 1) + "): ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < count && instruments[index] != null)
                        instruments[index].set(scanner);
                    else
                        System.out.println("Неверный индекс!");
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
                case 6 -> {
                    System.out.print("Введите индекс инструмента (0-" + (count - 1) + "): ");
                    int index = scanner.nextInt();

                    if (index >= 0 && index < count && instruments[index] != null) {
                        Instrument inst = instruments[index];

                        if (inst instanceof PercussionInstrument pi) {
                            System.out.println("Настроим инструмент");
                            pi.tune();
                        } else if (inst instanceof StringInstrument si) {
                            System.out.print("Введите номер струны для игры: ");
                            int stringNum = scanner.nextInt();
                            si.pluckString(stringNum);
                        } else if (inst instanceof WindInstrument wi) {
                            System.out.println("Введите новое направление воздуха (DIRECT / TRANSVERSE):");
                            String dir = scanner.next();
                            wi.changeAirDirection(AirDirection.valueOf(dir.toUpperCase()));
                        }

                    } else {
                        System.out.println("Неверный индекс!");
                    }
                }
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}
//20