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

//    public Dog() {
//        this.animal = new Animal();
//    }

    public static Dog set(Scanner scanner, Animal animal) {

        Dog dog = new Dog(animal, " ", TrainingLevel.UNTRAINED);

        System.out.println("Введите породу собаки:");
        dog.breed = scanner.next();

        System.out.println("Введите уровень дрессировки (UNTRAINED, BASIC, ADVANCED):");
        dog.trainingLevel = TrainingLevel.valueOf(scanner.next());

        return dog;
    }

    public void edit(Scanner scanner) {

        animal.edit(scanner);

        System.out.println("Введите новую породу:");
        this.setBreed(scanner.next());

        System.out.println("Введите новый уровень дрессировки (UNTRAINED, BASIC, ADVANCED):");
        this.setTrainingLevel(TrainingLevel.valueOf(scanner.next()));
    }

//    public void makeSound() {
//        animal.makeSound();
//    }

    public void run() {
        animal.run();
    }

    public void bite() {
        animal.bite();
    }

    public void jump() {
        System.out.println(animal.getName() + " прыгает");
    }

    public Animal getAnimal() {
        return animal;
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

    @Override
    public String toString() {
        return "Dog{" +
                "animal=" + animal +
                ", breed='" + breed + '\'' +
                ", trainingLevel=" + trainingLevel +
                '}';
    }
}
