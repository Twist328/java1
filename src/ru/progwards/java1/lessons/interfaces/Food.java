package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight {
    double weight;



    public Food(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }



    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeight) {

        if (this.weight < smthHasWeight.getWeight()) {
            return CompareResult.LESS;
        } else if (this.weight == smthHasWeight.getWeight()) {
            return CompareResult.EQUAL;
        } else
            return CompareResult.GREATER;
    }
    private double weight() {
        return 0.0;
    }
}








