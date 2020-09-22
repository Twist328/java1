package ru.progwards.java1.lessons.interfaces;

import java.util.Objects;

import static java.lang.Double.compare;
import static ru.progwards.java1.lessons.interfaces.Animal.AnimalKind.*;


public class Animal implements FoodCompare, CompareWeight {

    public double getFoodPrice() {
        return calculateFoodWeight() * getFood1kgPrice();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return compare(animal.weight, weight) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(weight);
    }

    final double weight;

    public Animal(double weight) {
        this.weight = weight;
    }


    @Override
    public int compareFoodPrice() {
        return 0;
    }


    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight){


        if (this.weight < smthHasWeight.getWeight()) {
            return CompareResult.LESS;
        } else if (this.weight == smthHasWeight.getWeight()) {
            return CompareResult.EQUAL;
        } else
            return CompareResult.GREATER;
    }



    enum AnimalKind {
        ANIMAL,
        COW,
        HAMSTER,
        DUCK
    }

    public AnimalKind getKind() {
        return ANIMAL;
    }

    enum FoodKind {
        HAY,
        CORN,
        UNKNOWN

    }

    public FoodKind getFoodKind() {

        return FoodKind.UNKNOWN;
    }

    @Override
    public int compareFoodPrice(Animal animal) {

        return Double.compare(this.getFoodPrice(), animal.getFoodPrice());
    }


    public double getFood1kgPrice() {

        if (getKind() == ANIMAL) {
            return 0.0;
        } else if (getKind() == COW) {
            return 20.0;
        } else if (getKind() == AnimalKind.HAMSTER) {
            return 50.0;
        } else if (getKind() == DUCK) {
            return 50.0;
        }

        return 0;
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

    public double calculateFoodWeight() {
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
        return COW;
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
        return HAMSTER;
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
        return DUCK;
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