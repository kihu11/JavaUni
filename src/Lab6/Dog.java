package Lab6;

import java.util.Scanner;

public class Dog extends Animal {

    protected String breed;
    protected TrainingLevel trainingLevel;
    protected double tailLength;

    public Dog(){
        super();
    }

    public Dog(String name, int age, double weight, String breed, TrainingLevel trainingLevel, double tailLength) {
        super(name, age, weight);
        this.breed = breed;
        this.trainingLevel = trainingLevel;
        this.tailLength = tailLength;
    }

    public static Dog set(Scanner scanner) {
        Dog object = new Dog("", 0, 0, "", TrainingLevel.UNTRAINED, 0);
        System.out.println("Опишите собаку.");
        System.out.println();

        System.out.print("Введите имя собаки: ");
        object.setName(scanner.next());

        System.out.print("Введите возраст собаки: ");
        object.setAge(scanner.nextInt());

        System.out.print("Введите вес собаки: ");
        object.setWeight(scanner.nextDouble());

        System.out.println("Введите натренированность собаки(UNTRAINED, BASIC, ADVANCED): ");
        object.setTrainingLevel(TrainingLevel.valueOf(scanner.next()));

        System.out.println("Введите длину хвоста собаки: ");
        object.setTailLength(scanner.nextDouble());

        return object;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public TrainingLevel getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(TrainingLevel trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        if (tailLength <= 0) {
            System.out.println("Значение не может быть отрицательным. Переменной присвоено значение 1. Программа продолжается.");
            this.tailLength = 1;
        } else {
            this.tailLength = tailLength;
        }
    }

    public void printTrainingLevel(){
        System.out.println(name + " уровень дрессировки: " + trainingLevel);
    }

    @Override
    public void bite() {
        System.out.println("Собака укусила");
    }

    @Override
    public void makeSound() {
        System.out.println("Гав");
    }

    @Override
    public void run() {
        System.out.println("Собака бежит");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + getBreed() + '\'' +
                ", trainingLevel=" + getTrainingLevel() +
                ", tailLength=" + getTailLength() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", weight=" + getWeight() +
                '}';
    }
}
