package NugnayaFugnya;

public class BestTest {
    enum Length { LONGEST, AVERAGE, MINIMUM ;}

    public static void main(String[] args) {

            final var length = Length.AVERAGE; // line n1
            switch (length) { // line n2
                case AVERAGE:  { System.out.print(length);} // line n3
            }
        }
    }

