package NugnayaFugnya;

public class BestTest {
    enum Length { LONGEST, AVERAGE, MINIMUM ;}

    public static void main(String[] args) {

            final var length = Length.AVERAGE; // уровень n1
            switch (length) {   // уровень n2
                case AVERAGE:  { System.out.print(length);} // уровень n3
            }
        }
    }

