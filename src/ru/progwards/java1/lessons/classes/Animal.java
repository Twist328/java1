package ru.progwards.java1.lessons.classes;

public class Animal {
final double weight;
    public Animal(double weight) {
        this.weight = weight;
    }

enum AnimalKind {
    ANIMAL,
    COW,
    HAMSTER,
    DUCK
}

    public  AnimalKind getKind() {
        return AnimalKind.ANIMAL;
    }

enum FoodKind {
    UNKNOWN,
    HAY,
    CORN
}

    public FoodKind getFoodKind() {
        return FoodKind.UNKNOWN;

    }

    @Override
    public String toString() {

        return "I am" + " " + getKind() + "," + " " + "eat" + " " + getFoodKind();
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        final double x = 0.02;
        return x;

    }

    public  double calculateFoodWeight() {
        return getWeight() * getFoodCoeff();
    }
    public String toStringFull() {

        return "I am" + " " + getKind() + "," + " " + "eat" + " " + getFoodKind() + " " + calculateFoodWeight();
    }

}

class Cow extends Animal {

    public Cow(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.COW;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.HAY;
    }

    @Override
    public double getFoodCoeff() {
        final double x = 0.05;
        return x;

    }

    @Override
    public String toStringFull() {
        return super.toStringFull();
    }
}

class Hamster extends Animal {

    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.HAMSTER;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        final double x = 0.03;
        return x;
    }

    @Override
    public String toStringFull() {
        return super.toStringFull();
    }
}

class Duck extends Animal {

    public Duck(double weight) {
        super(weight);
    }

    @Override
    public AnimalKind getKind() {
        return AnimalKind.DUCK;
    }

    @Override
    public FoodKind getFoodKind() {
        return FoodKind.CORN;
    }

    @Override
    public double getFoodCoeff() {
        final double x = 0.04;
        return x;
    }

    @Override
    public String toStringFull() {
        return super.toStringFull();
    }

    public static void main(String[] args) {

        Animal animal = new Animal(0.0);
        Cow animal1 = new Cow(170.0);
        Hamster animal2 = new Hamster(0.3);
        Duck animal3 = new Duck(3.0);

        System.out.println(animal);
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal3);

    }
}