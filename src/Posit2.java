public class Posit2 {
    static long factorial(long n) {

        long result = 1l;
        for (long i = 1l; i <= n; i++) {
            result = result * i;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(factorial(17));
    }
}
