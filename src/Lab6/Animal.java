package Lab6;

import java.util.Scanner;

public class Animal {

    private String name;
    private int age;
    private double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public static Animal set(Scanner scanner) {

        Animal animal = new Animal(" ", 0, 0);

        System.out.println("Введите имя животного:");
        animal.setName(scanner.next());

        System.out.println("Введите возраст животного:");
        animal.setAge(scanner.nextInt());

        System.out.println("Введите вес животного:");
        animal.setWeight(scanner.nextDouble());

        return animal;
    }

    public void edit(Scanner scanner) {
        System.out.println("Редактируем данные");

        System.out.println("Введите новое имя:");
        this.setName(scanner.next());

        System.out.println("Введите новый возраст:");
        this.setAge(scanner.nextInt());

        System.out.println("Введите новый вес :");
        this.setWeight(scanner.nextDouble());

    }

    public Animal() {
    }

    public void makeSound() {
        System.out.println(name + " издает звук");
    }

    public void run() {
        System.out.println(name + " бежит");
    }

    public void bite() {
        System.out.println(name + " кусает");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
