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
        int[] a = {14, 25, 36, -48, 105, -76};
        int sum = sumArrayItems(a);
        System.out.println(sum);
        
    }

}



