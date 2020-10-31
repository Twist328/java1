package Mama;

import java.io.IOException;

public class Test112 {

    int n;

    public static void doSomething(int n) throws IOException {
    }

    public void test(int n) throws IOException {
        try {
            doSomething(n);

        } catch (IOException e) {

        } finally {
            if (n == 0) {
                System.out.println("file not exist");
                System.out.println("finally executed");
            } else {
                System.out.println("finally executed");
            }
        }
        try {
            if (n == 0) {
                throw new IOException("file not exist");
            }
        } finally {
            //System.out.println("finally executed");
        }
    }
}

