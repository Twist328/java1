package Tvist328;

class TestsArray {


    public static int sumArrayItems(int[] a) {
        int sum = 0;
        for (int value : a) {
            sum += value;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a99 = {14, 25, 36, -48, 105, -76};
        int sum = sumArrayItems(a99);
        System.out.println(sum);
        String str1 = "12345";
        String str2 = "12345";
        System.out.println(str1 == str2);
        System.out.println(Math.log10(45));
    }

}



