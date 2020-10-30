package Mama;

import java.io.IOException;

public class Test111 {//Тест 11.1

    public static void doExceptions(int n) throws Throwable {
        Throwable suppressed = null;
        try {
            System.out.println("doExceptions 1");
            if (n == 0)
                throw new Exception("Exception in try");
            System.out.println("doExceptions 2");
        } catch (Throwable t) {
            suppressed = t;
            throw t;
        } finally {
            try {
                throw new Exception("Exception in finally");
            } catch (Throwable t) {
                if (suppressed != null)
                    t.addSuppressed(suppressed);
                throw t;
            }
        }
    }
    public void doSomething(int n) throws IOException {
    }
        public void test(int n){

        }

    public static void main(String[] args) throws IOException {
        try {
            doExceptions(1);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            for (Throwable t : e.getSuppressed())
                System.out.println(t.getMessage() + " (suppressed)");
        }
    }

}
