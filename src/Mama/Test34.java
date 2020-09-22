package Mama;

public class Test34 {
    public static void main(String[] args) {
        PersonCompare personCompare = new PersonCompare() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        } ;
    }
}
