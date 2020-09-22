package Tvist823Tests;

public class Dog implements Speaking, Eating { // реализация двух интерфейсов в 3 классах
    public static void main(String[] args) {
        Dog say = new Dog();
        System.out.println(" Собака не может говорить - а только лает: " +(new Dog().say()));
        Dog eat = new Dog();
        System.out.println(" Собака ну очень любит покушать: " +(new Dog().eat()));
        Goat say1 = new Goat();
        System.out.println(" Козёл  не может говорить - а только произносит: " +(new Goat().say()));
        Goat eat1 = new Goat();
        System.out.println(" Козёл ну очень любит покушать: " +(new Goat().eat()));
        Dack say2 = new Dack();
        System.out.println(" Селезень  не может говорить - а только произносит: " +(new Dack().say()));
        Dack eat2 = new Dack();
        System.out.println(" Селезень ну очень любит покушать: " +(new Dack().eat()));
    }

    @Override
    public String say() {
        return "Гав";
    }

    @Override
    public String eat() {
        return "Мясо";
    }
}

 class Goat implements Speaking, Eating {

    @Override
    public String say() {
        return "Мее";
    }

    @Override
    public String eat() {
        return "Сено" ;
    }
}
class Dack implements Speaking, Eating {
    @Override
    public String say() {
        return "КРЯ-КРЯ";
    }

    @Override
    public String eat() {
        return "Зерно кукурузы";
    }

}

