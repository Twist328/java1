package Slone;

public class Goat implements Eating,Speaking {

    @Override
    public String eat() {
        return "Сено";
    }

    @Override
    public String say() {
        return "Мее" ;
    }
    public static void main(String[] args) {
        System.out.println("Козёл не сможет Вам сказать ПРИВЕТ!, а только: "+ new Goat().say());
        System.out.println("Козёл не ест тирамиссу но любит: "+ new Goat().eat());
    }
}
