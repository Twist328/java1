package Mama;

public class TesttoCharArray {

        public static void main(String args[]){
            String str = "МАМА МЫЛА РАМУ";
            char[] result = str.toCharArray();

            String str1 = "254137";
            char[] result1 = str1.toCharArray();

            System.out.println("Char array:");

            for (int i = 0; i < result.length; i++)
                System.out.println("Element [" + i + "]: " + result[i]);

            for (int i = 0; i < result1.length; i++)
                System.out.println("Element [" + i + "]: " + result1[i]);

            /* ТО ЕСТЬ МЕТОД str.toCharArray()
            ПРЕОБРАЗОВАЛ СТРОКУ "МАМА МЫЛА РАМУ" В МАССИВ ЧАРОВ : {'МАМА', 'МЫЛА','РАМУ'}*/
        }
    }

