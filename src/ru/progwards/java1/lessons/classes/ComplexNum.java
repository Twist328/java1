package ru.progwards.java1.lessons.classes;

public class ComplexNum {

    int a;
    int b;

    ComplexNum result;

    public ComplexNum(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {

        return String.valueOf(this.a) + "+" + this.b + "i";
    }

    public ComplexNum add(ComplexNum num) {


        ComplexNum result = new ComplexNum(this.a + num.a, this.b + num.b);

        return result;
    }

    public ComplexNum sub(ComplexNum num) {


        ComplexNum result = new ComplexNum(this.a - num.a, this.b - num.b);
        return result;
    }

    public ComplexNum mul(ComplexNum num) {

        ComplexNum result = new ComplexNum(this.a * num.a - this.b * num.b, this.a * num.b + this.b * num.a);

        return result;
    }

    public ComplexNum div(ComplexNum num) {

        ComplexNum result =
                new ComplexNum((this.a * num.a + this.b * num.b) /
                        (num.a * num.a + num.b * num.b), (this.b * num.a - this.a * num.b) / (num.a * num.a + num.b * num.b));
        return result;
    }

    public static void main(String[] args) {
        ComplexNum result = new ComplexNum(56, 1);
        ComplexNum result1 = new ComplexNum(0 - 0, 0 - 0);
        ComplexNum result2 = new ComplexNum(0 * 0 - 0 * 0, 0 * 0 + 0 * 0);
        ComplexNum result3 = new ComplexNum(1000 / 100, 100 / 1000);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

}






