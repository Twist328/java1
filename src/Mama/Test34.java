package Mama;

import java.util.Objects;

public class Test34 {
    public static void main(String[] args) {
       /* PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        } ;

        //System.out.println(Objects.equals( null));
    */
        PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }

        };
        class Person {
            public String name;
            Person(String name) {
                this.name = name;
            }
        }

    }

    private static void someFunction(String name) {
    }
}