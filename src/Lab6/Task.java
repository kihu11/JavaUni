package Lab6;

import java.util.Scanner;

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
                            "4. прыгнуть\n" +
                            "5. вывести информацию\n"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> dog.makeSound();
                case 2 -> dog.run();
                case 3 -> dog.bite();
                case 4 -> dog.jump();
                case 5 -> System.out.println(dog);
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }

        Puppy puppy = Puppy.set(scanner);

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. подать голос\n" +
                            "2. пробежаться\n" +
                            "3. укусить\n" +
                            "4. прыгнуть\n" +
                            "5. поиграть\n" +
                            "6. вывести информацию\n"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> puppy.makeSound();
                case 2 -> puppy.run();
                case 3 -> puppy.bite();
                case 4 -> puppy.jump();
                case 5 -> puppy.play();
                case 6 -> System.out.println(puppy);
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}
