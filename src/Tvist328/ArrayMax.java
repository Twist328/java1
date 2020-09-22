package Tvist328;

public class ArrayMax {

    public int arrayMax(int[] a) { // ЗАДАЧА НА ВОЗВРАТ МАКСИМУМА ИЗ a[] = {}; пустого, нулевого МАССИВА

        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }

}







