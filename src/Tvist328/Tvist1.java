package Tvist328;

public class Tvist1 {
    static double fractional(double num) { // Деление в Java (ОСТАТОК ОТ ДЕЛЕНИЯ)
        return num % 1;
    }//1 вариант решения задачи

    public static void main(String[] args) {

        System.out.println(fractional(0.00));
        System.out.println(fractional(1.00));
        System.out.println(fractional(1.53));
        System.out.println(fractional(98.45));
        double num = 1.53;
        int n = (int) num;
        System.out.println(num-n); //2 вариант решения задачи

    }
}
