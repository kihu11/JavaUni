package Lab6;

import java.util.Scanner;

public class Dog {
    private final Animal animal;
    private String breed;
    private TrainingLevel trainingLevel;

    public Dog(Animal animal, String breed, TrainingLevel trainingLevel) {
        this.animal = animal;
        this.breed = breed;
        this.trainingLevel = trainingLevel;
    }

    public Dog() {
        this.animal = new Animal();
    }

    public static Dog set(Scanner scanner) {
        Dog dog = new Dog();

        System.out.println("Введите имя собаки:");
        dog.animal.setName(scanner.next());

        System.out.println("Введите возраст собаки:");
        dog.animal.setAge(scanner.nextInt());

        System.out.println("Введите вес собаки:");
        dog.animal.setWeight(scanner.nextDouble());

        System.out.println("Введите породу собаки:");
        dog.breed = scanner.next();

        System.out.println("Введите уровень дрессировки (UNTRAINED, BASIC, ADVANCED):");
        dog.trainingLevel = TrainingLevel.valueOf(scanner.next());

        return dog;
    }

    public void makeSound() {
        System.out.println("Собака гавкает");
    }

    public void run() {
        animal.run();
    }

    public void bite() {
        animal.bite();
    }

    public void jump() {
        System.out.println("Собака прыгает");
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "animal=" + animal +
                ", breed='" + breed + '\'' +
                ", trainingLevel=" + trainingLevel +
                '}';
    }
}
