package Task;

public class FactorialClass {
    static long factorial(long n) {

        long result = 1l;
        for (long i = 1l; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(factorial(20));

        System.out.println(Math.pow(20l, 3));
        //for ( ; ; ) {//вечный цикл


        if (1 > 2 && 5 >= 0)

            System.out.println("Что-то из этого условия точно верно");

        else

            System.out.println("Быть может что-то в этом условии верно, но что-то точно нет");

        int i = (int)765.567;//отсекает остаток
        System.out.println(i);
    }
}

