package Lab6;

import java.util.Scanner;

public class Puppy {
    private final Dog dog;
    private EnergyLevel energyLevel;

    public Puppy(Dog dog, EnergyLevel energyLevel) {
        this.dog = dog;
        this.energyLevel = energyLevel;
    }

    public Puppy() {
        this.dog = new Dog();
    }

    public static Puppy set(Scanner scanner) {
        System.out.println("Опишите щенка: ");
        Dog dog = Dog.set(scanner);

        System.out.println("Введите уровень энергичности (CALM, ENERGETIC):");
        EnergyLevel level = EnergyLevel.valueOf(scanner.next());

        return new Puppy(dog, level);
    }

    public void makeSound() {
        System.out.println("Щенок тявкает");
    }

    public void run() {
        dog.run();
    }

    public void bite() {
        dog.bite();
    }

    public void jump() {
        dog.jump();
    }

    public void play() {
        System.out.println("Щенок играет");
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "dog=" + dog +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
