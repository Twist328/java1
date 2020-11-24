package Tvist328;

public class ArrayMax {

    public static int arrayMax(int[] a) { // ЗАДАЧА НА ВОЗВРАТ МАКСИМУМА ИЗ a[] = {}; МАССИВА

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[]a={226,118,-335,0,160};
        int max= arrayMax(a);
        System.out.println(max);

    }
}







