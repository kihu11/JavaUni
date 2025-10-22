package Lab6;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Создаем животное");
        Animal animal = Animal.set(scanner);

        System.out.println("Создаем собаку на основе собаки");
        Dog dog = Dog.set(scanner, animal);

        System.out.println("Создаем щенка на основе собаки");
        Puppy puppy = Puppy.set(scanner, dog);

        while (true) {
            System.out.println(
                    "Выберете пункт меню:\n" +
                            "0. выход\n" +
                            "1. подать голос\n" +
                            "2. пробежаться\n" +
                            "3. укусить\n" +
                            "4. прыгнуть\n" +
                            "5. вывести информацию\n" +
                            "6. отредактировать информацию"
            );
            int choice = scanner.nextInt();
            if (choice == 0)
                break;

            switch (choice) {
                case 1 -> puppy.makeSound();
                case 2 -> puppy.run();
                case 3 -> puppy.bite();
                case 4 -> puppy.jump();
                case 5 -> System.out.println(puppy);
                case 6 -> puppy.edit(scanner);
                default -> System.out.println("Неверный пункт меню, повторите ввод.");
            }
        }
        scanner.close();
    }
}

