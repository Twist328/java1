package Comparables;

import java.util.Arrays;

public class Employee implements Comparable {

    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public int compareTo(Object obj) {
        Employee entry = (Employee) obj;
        int result = name.compareTo((entry.name));
        if (result != 0) {
            return result;
        }
            result = id - ((entry.id));//развёрнутый вариант CompareTo хороший вариант при совпадениях name
            if (result != 0) {
                return (int) result / Math.abs(result);
            }
            return 0;
        }


    public static void main(String[] args) {
        Employee[] empArr = new Employee[4];
// заполняем массив объектов Employee данными
        empArr[0] = new Employee(25, "Генулик", 21, 10000);//CompareTo если имена совпадают
        empArr[1] = new Employee(20, "Дмитрий", 49, 20000);//то сортирует по id
        empArr[2] = new Employee(5, "Виктор", 45, 5000);//если правильно переопределен метод
        empArr[3] = new Employee(26, "Генулик", 22, 10000);
// сортируем массив с использованием Comparable
        Arrays.sort(empArr);
        System.out.println("Стандартная сортировка для массива объектов Employee:\n"+Arrays.toString(empArr));

    }

    @Override
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" + this.salary + "]";
    }
}
