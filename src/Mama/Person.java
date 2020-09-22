package Mama;

import java.util.Comparator;



class Person {
    public String name;

    public Person(String name) {
        this.name = name;
    }
}

abstract class PersonCompare {

    public int compare(Person p1, Person p2) {
        return 0;
    }

}



