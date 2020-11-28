package Goon;


import java.util.Comparator;
import java.util.TreeSet;

class User {//Создайте метод с сигнатурой public TreeSet<User> createSet()
    // который создает и возвращает TreeSet так, что бы пользователи оказались
    // упорядочены по убыванию id*/


    public Integer id;
    public String name;

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TreeSet<User> createSet() {
        TreeSet<User>treeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return  Integer.compare(o2.id, o1.id);
            }
        });
        return treeSet;
    }
}

