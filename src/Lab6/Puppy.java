package Lab6;

import java.util.Scanner;

public class Puppy {

    private final Dog dog;
    private EnergyLevel energyLevel;

    public Puppy(Dog dog, EnergyLevel energyLevel) {
        this.dog = dog;
        this.energyLevel = energyLevel;
    }

//    public Puppy() {
//        this.dog = new Dog();
//    }

    public void edit(Scanner scanner) {

        dog.edit(scanner);

        System.out.println("Введите новый уровень энергии (CALM, ENERGIZED)");
        this.setEnergyLevel(EnergyLevel.valueOf(scanner.next()));
    }

    public static Puppy set(Scanner scanner, Dog dog) {

        System.out.println("Опишите щенка: ");
        Puppy puppy = new Puppy(dog, EnergyLevel.CALM);

        System.out.println("Введите уровень энергичности (CALM, ENERGETIC):");
        EnergyLevel level = EnergyLevel.valueOf(scanner.next());

        return puppy;
    }

    public void makeSound() {
        System.out.println(dog.getAnimal().getName() + " тявкает");
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

    public EnergyLevel getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(EnergyLevel energyLevel) {
        this.energyLevel = energyLevel;
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "dog=" + dog +
                ", energyLevel=" + energyLevel +
                '}';
    }
}
