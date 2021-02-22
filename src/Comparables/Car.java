package Comparables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car implements Comparable<Car> {

    private int manufactureYear;
    private String model;
    private int maxSpeed;

    public Car(int manufactureYear, String model, int maxSpeed) {
        this.manufactureYear = manufactureYear;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public int compareTo(Car o) {
        return this.getManufactureYear() - o.getManufactureYear();
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    @Override
    public String toString() {
        return "Car{" +
                "manufactureYear=" + manufactureYear +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class MaxSpeedCarComparator implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getMaxSpeed()-o2.getMaxSpeed();
    }

    static class Main {

        public static void main(String[] args) {

            List<Car> cars = new ArrayList<>();

            Car ferrari = new Car(1990, "Ferrari 360 Spider", 310);
            Car lambo = new Car(2012, "Lamborghini Gallardo", 290);
            Car bugatti = new Car(2010, "Bugatti Veyron", 350);
            Car jiguly  = new Car(2005, "Jiguly Six", 140);
            Car lada = new Car(2015, "Lada Pryora", 170);

            cars.add(ferrari);
            cars.add(bugatti);
            cars.add(lambo);
            cars.add(jiguly);
            cars.add(lada);

            Collections.sort(cars);// Cортировка с помощью Comparable по году выпуска
            System.out.println("Cортировка авто по году выпуска с завода:");
            System.out.println(cars+"\n");

            Comparator speedComparator = new MaxSpeedCarComparator();
            Collections.sort(cars, speedComparator);//Cортировка с помощью Comparator по максимальной скорости
            System.out.println("Cортировка авто по максимальной скорости:");
            System.out.print(cars);

        }
    }
}
