package Tvist328;

public class Calculator {
    private int result;

    Calculator() {

        this.result = 0;
    }

    public void set(int num) {
        this.result = num;
    }

    public void add(int num) {

        this.result = result + num;
    }

    public void sub(int num) {
        this.result = result - num;
    }

    int getResult() {
        return this.result;
    }

}
