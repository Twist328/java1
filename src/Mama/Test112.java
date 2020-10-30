package Mama;

import java.io.IOException;

public class Test112 {

    int n;

    public static void doSomething(int n) throws IOException {
    }

    public static void test(int n) throws Throwable {
        try {
            doSomething(n);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new IOException("finally executed");

        }
    }

    public static void main(String[] args) throws Throwable {

        Test112 test = new Test112();
        doSomething(9);
        doPrint=false;

    }
}
