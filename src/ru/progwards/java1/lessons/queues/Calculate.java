package ru.progwards.java1.lessons.queues;

public class Calculate {

    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
    public static double calculation1() {
        StackCalc res = new StackCalc();
        res.push(2.2);
        res.push(3);
        res.push(12.1);
        res.add();
        res.mul();
        return res.pop() ;      //2.2*(3+12.1), используя класс StackCalc
    }

    public static double calculation2() {
        StackCalc res = new StackCalc();
        res.push(737.22);
        res.push(24);
        res.add();
        res.push(55.6);
        res.push(12.1);
        res.sub();
        res.div();
        res.push(19);
        res.push(3.33);     //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
        res.sub();
        res.push(87);
        res.push(2);
        res.push(13.001);
        res.push(9.2);
        res.sub();
        res.mul();
        res.add();
        res.mul();
        res.add();
        return res.pop();
    }
}


