package Goon;

import java.util.Date;
import java.util.Locale;

public class Person {

    public String name;
    public Date birth;
    public double salary;

    Person(String name, Date birth, double salary) {
        this.name = name;
        this.birth = birth;
        this.salary = salary;
    }

    public Person() {

    }

    static void printPersons(Person... persons) {
        for (Person person : persons) {
            System.out.format(new Locale("ru"), "|%-10s|%2$td/%2$tm/%2$tY|%3$,10.2f|\n", person.name, person.birth, person.salary);
        }
    }

    public static void main(String[] args) {
        new Person().printPersons(new Person("Коля", new Date(0), 2000000.001),
                new Person("Дима", new Date(199234885678L), 55331.123),
                new Person("Ваня", new Date(598812345678L), 32999.888));
        Person[] persons = {new Person("Вася", new Date(0), 200000.001),
                new Person("Петя", new Date(199234885678L), 55331.123),
                new Person("Коля", new Date(598812345678L), 99999.999)};
        printPersons(persons);
        System.out.format("|%04d|%#x|%2.1f|", 2, 15, 3.25);
    }
}


