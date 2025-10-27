package Java.Lab7;

import Java.Lab7.Classes.Instrument;
import Java.Lab7.Classes.PercussionInstrument;

import java.util.Scanner;

public class Task {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Instrument[] instrument = new Instrument[4];

      //  instrument[0] = new PercussionInstrument();

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. Сыграть мелодию" +
                            "2. вывести информацию\n" +
                            "3. отредактировать информацию"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
//                case 1 -> ;
//                case 2 -> ;
//                case 3 -> ;
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }
        scanner.close();

    }
}
//20