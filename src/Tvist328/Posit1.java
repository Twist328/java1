package Tvist328;

public class Posit1 {
    static String textGrade(int grade) {  // Aвтоматизация с помощью циклов методики оценки
        if (grade < 0) return "не определено";
        if (grade == 0) return "не оценено";
        if (grade <= 20) return "очень плохо";
        if (grade <= 40) return "плохо";
        if (grade <= 60) return "удовлетворительно";
        if (grade <= 80) return "хорошо";
        if (grade <= 100) return "отлично";

        return "не определено";
    }

    public static void main(String[] args) {
        System.out.println(textGrade(30));

        byte value = (byte)3;
        int result =  (value & 1) & 0xFF;
        System.out.println(result);

        int a = 1 & 1;
        System.out.println(a);


        }
    }

    class Enumes {




        enum Grade {
            VERYBAD,
            BAD,
            SATISFACTORILY,
            GOOD,
            EXCELLENT,
            NOTDEFINED
        }

        static Grade intToGrade(int grade) {

            switch (grade) {


                case 1:
                    return Grade.VERYBAD;
                case 2:
                    return Grade.BAD;
                case 3:
                    return Grade.SATISFACTORILY;
                case 4:
                    return Grade.GOOD;
                case 5:
                    return Grade.EXCELLENT;
                default:
                    return Grade.NOTDEFINED;

            }
        }
    }