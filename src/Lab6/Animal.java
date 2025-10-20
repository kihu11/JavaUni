package Lab6;

abstract class Animal {

    protected String name;
    protected int age;
    protected double weight;

    public abstract void makeSound();

    public abstract void run();

    public abstract void bite();

    public Animal() {

    }

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if (age <= 0) {
            System.out.println("Значение не может быть отрицательным. Переменной присвоено значение 1. Программа продолжается.");
            this.age = 1;
        } else {
            this.age = age;
        }
    }

    protected double getWeight() {
        return weight;
    }

    protected void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("Значение не может быть отрицательным. Переменной присвоено значение 1. Программа продолжается.");
            this.weight = 1;
        } else {
            this.weight = weight;
        }
    }
}
