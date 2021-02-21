package Persons;

import java.util.Arrays;
import java.util.Comparator;

public class School implements Comparable<School>{
    private int num_of_students;
    private String name;

    public School(String name, int num_of_students) {
        this.name = name;
        this.num_of_students = num_of_students;
    }



    public int getNumOfStudents() {
        return this.num_of_students;
    }
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(School o) {

        return this.num_of_students-o.num_of_students;

    }

    @Override
    public String toString() {
        return "[" + "name=" + this.name + ", num=" + this.num_of_students + "]";
    }
}

class SortSchools implements Comparator<School> {
    @Override
    public int compare(School sch1, School sch2) {
        if (sch1.getNumOfStudents() == sch2.getNumOfStudents())
            return 0;
        else
            return sch1.getNumOfStudents() > sch2.getNumOfStudents() ? 1 : -1;
    }

    public static void main(String[] args) {
        School[]s=new School[10];
        s[0] = new School("sch1", 122);
        s[1] = new School("sch2", 420);
        s[2] = new School("sch3", 35);
        s[3] = new School("sch4", 20);
        s[4] = new School("sch5", 25);
        s[5] = new School("sch6", 21);
        s[6] = new School("sch7", 320);
        s[7] = new School("sch8", 820);
        s[8] = new School("sch9", 1220);
        s[9] = new School("sch10", 20);

        Arrays.sort(s);
        System.out.println("Сортировка учебных заведений по количеству учащихся:\n"+Arrays.toString(s));//Camparable

        School sch1 = new School("sch1", 20);
        School sch2 = new School("sch2", 15);

        SortSchools sortSch = new SortSchools();//Компаратор для 2 школ
        int retval = sortSch.compare(sch1, sch2);
        switch(retval) {
            case -1: {
                System.out.println("The " + sch2.getName() + " is bigger!");
                break;
            }
            case 1: {
                System.out.println("The " + sch1.getName() + " is bigger!");
                break;
            }
            default:
                System.out.println("The two schools are of the same size!");
        }
    }
}



