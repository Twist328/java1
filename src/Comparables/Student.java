package Comparables;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //public Student() {

   // }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Student p) {
        return this.age-p.age;
    }
    public static void main(String[] args) {
        Student[]e =new Student[4];
        e[0]  = new Student("Adam", 65);
        e[1] = new Student("Steve", 60);
        e[2] = new Student("Adams", 55);
        e[3] = new Student("Steven", 40);
        Arrays.sort(e);
                System.out.println(Arrays.toString(e));
        }

    @Override
    public String toString() {
        return "[name=" + this.name + ", age=" + this.age + "]";
    }
}

