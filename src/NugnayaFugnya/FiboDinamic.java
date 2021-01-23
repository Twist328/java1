package NugnayaFugnya;

import java.math.BigInteger;

public class FiboDinamic {
    public static int dynamicFibonacci(int n)
    {
        int[] prevSolutions = new int[n];
        if (n == 1 || n == 2)
        {
            return 1;
        }
        prevSolutions[0] = 1;
        prevSolutions[1] = 1;
        for (int i = 2; i < prevSolutions.length; i++)
        {
            prevSolutions[i] = prevSolutions[i-1] + prevSolutions[i-2];
        }
        return prevSolutions[n-1];
    }
    public static int iterativeFactorial(int n) {

        int answer = 1;
        for (int i = 1; i <=n; i++) {
            answer *= i;
        }
        return answer;
    }
    static BigInteger fibonacci(int n) {
        if (n <= 2) return BigInteger.ONE;
        BigInteger prev = BigInteger.ONE, sum = BigInteger.ONE;
        BigInteger next = null;
        for (int i = 2; i < n; i++) {
            next = prev.add(sum);
            sum = prev;
            prev = next;
        }
        return next;
    }
    public static void main(String[] args) {


        System.out.println(dynamicFibonacci(46));
        System.out.println(iterativeFactorial(6)-iterativeFactorial(4));
        System.out.println(fibonacci(1000));
    }
}
