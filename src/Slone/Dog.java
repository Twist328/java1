package Slone;

public class Dog implements Eating,Speaking {

    @Override
    public String eat() {
        return "Мясо";
    }

    @Override
    public String say() {
        return  "Гав";
    }
    public static void main(String[] args) {
        System.out.println("Собака вместо ЗДРАВСТВУЙ!, говорит : "+ new Dog().say());
        System.out.println("Собака может есть многие продукты но больше всего любит: "+ new Dog().eat());
    }
}
