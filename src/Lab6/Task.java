package Lab6;

import java.util.Scanner;
import java.util.SortedMap;

public class Task {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Dog dog = Dog.set(scanner);

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. подать голос\n" +
                            "2. пробежаться\n" +
                            "3. укусить\n" +
                            "4. вывести информацию\n"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    dog.makeSound();
                    break;
                case 2:
                    dog.run();
                    break;
                case 3:
                    dog.bite();
                    break;
                case 4:
                    System.out.println(dog);
                    break;
                default:
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
            }
        }

        Puppy pup = Puppy.set(scanner);

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. подать голос\n" +
                            "2. пробежаться\n" +
                            "3. укусить\n" +
                            "4. вывести информацию\n" +
                            "5. поиграть\n"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1:
                    pup.makeSound();
                    break;
                case 2:
                    pup.run();
                    break;
                case 3:
                    pup.bite();
                    break;
                case 4:
                    System.out.println(pup);
                    break;
                case 5:
                    pup.play();
                    break;
                default:
                    System.out.println("выбран неправильный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}

