package NugnayaFugnya;

import java.util.Random;

public class BestTest {
    enum Length {LONGEST, AVERAGE, MINIMUM;}

    public static void main(String[] args) {

        final var length = Length.AVERAGE; // уровень n1
        switch (length) {   // уровень n2
            case AVERAGE: {
                System.out.print(length+"\n\n");
            } // уровень n3
        }
//Сорт Аррай
        double[] ints = new Random().doubles(100,-100,100).toArray();
        for (int i = 0; i < ints.length; i++) {
           // ints[i] = 50 - i;
        }
        System.out.println(java.util.Arrays.toString(ints));
        java.util.Arrays.sort(ints);
        System.out.println(java.util.Arrays.toString(ints));
    }
}
