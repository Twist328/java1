package Tvist328;

public class Person {

    private String name;
    private int age;
    private String country;

    public Person() {

        this.country = "RU";

    }

    public Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;

    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getCountry() {

        return country;
    }
}

