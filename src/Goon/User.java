package Goon;

import java.util.Comparator;
import java.util.TreeSet;

class User {//Создайте метод с сигнатурой public TreeSet<User> createSet()
    // который создает и возвращает TreeSet так, что бы пользователи оказались
    // упорядочены по убыванию id*/


    public Integer id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String name;

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static TreeSet<User> createSet() {
        TreeSet<User>treeSet = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return  Integer.compare(o2.id, o1.id);
            }
        });
        return treeSet;
    }

    public static void main(String[] args) {

        TreeSet<User> backsort = createSet();
        backsort.add(new User(1, "Вася"));
        backsort.add(new User(5, "Петя"));
        backsort.add(new User(2, "Коля"));
        backsort.add(new User(4, "Дима"));

        System.out.println(backsort);

        TreeSet<User> backsort1 = createSet();
        backsort1.add(new User(11, "Маша"));
        backsort1.add(new User(15, "Саша"));
        backsort1.add(new User(23, "Соня"));
        backsort1.add(new User(44, "Даша"));

        System.out.println(backsort1);

    }
}

