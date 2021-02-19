package Persons;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public int compareTo(Student p) {
        if (this.age == p.age)
            return 0;
        else
            return this.age > p.age ? 1 : -1;
    }


    public static void main(String[] args) {
        Student e1 = new Student("Adam", 65);
        Student e2 = new Student("Steve", 60);
        Student e3 = new Student("Adams", 55);
        Student e4 = new Student("Steven", 40);
        int retval = e1.compareTo(e4);
        switch (retval) {
            case -1: {
                System.out.println("The " + e2.getName() + " is older!");
                break;
            }
            case 1: {
                System.out.println("The " + e1.getName() + " is older!");
                break;
            }
            default:
                System.out.println("The two persons are of the same age!");
        }
    }
}
