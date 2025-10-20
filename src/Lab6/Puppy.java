package Lab6;

import java.util.Scanner;

public class Puppy extends Dog {

    private EnergyLevel energyLevel;

    public Puppy(String name, int age, double weight, String breed, TrainingLevel trainingLevel, double tailLength, EnergyLevel energyLevel) {
        super(name, age, weight, breed, trainingLevel, tailLength);
        this.energyLevel = energyLevel;
    }

    public static Puppy set(Scanner scanner) {
        Puppy object = new Puppy("", 0, 0, "", TrainingLevel.UNTRAINED, 0, EnergyLevel.CALM);
        System.out.println("Опишите щенка.");
        System.out.println();

        System.out.print("Введите имя щенка: ");
        object.setName(scanner.next());

        System.out.print("Введите возраст щенка: ");
        object.setAge(scanner.nextInt());

        System.out.print("Введите вес щенка: ");
        object.setWeight(scanner.nextDouble());

        System.out.println("Введите натренированность щенка(UNTRAINED, BASIC, ADVANCED): ");
        object.setTrainingLevel(TrainingLevel.valueOf(scanner.next()));

        System.out.println("Введите длину хвоста щенка: ");
        object.setTailLength(scanner.nextDouble());

        System.out.println("Введите натренированность щенка(CALM, ENERGIZED): ");
        object.setEnergyLevel(EnergyLevel.valueOf(scanner.next()));

        return object;
    }

    public EnergyLevel getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(EnergyLevel energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void play(){
        System.out.println("Щенок играется");
    }

    @Override
    public void run() {
        System.out.println("Щенок бежит");
    }

    @Override
    public void bite() {
        System.out.println("Щенок кусается");
    }

    @Override
    public void makeSound() {
        System.out.println("Тяф");
    }

    @Override
    public String toString() {
        return "Puppy{" +
                "energyLevel=" + getEnergyLevel() +
                ", breed='" + getBreed() + '\'' +
                ", trainingLevel=" + getTrainingLevel() +
                ", tailLength=" + getTailLength() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", weight=" + getWeight() +
                '}';
    }
}
