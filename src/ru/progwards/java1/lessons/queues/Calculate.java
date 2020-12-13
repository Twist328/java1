package ru.progwards.java1.lessons.queues;

public class Calculate {
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
        StackCalc rez = new StackCalc();
        rez.push(737.22);
        rez.push(24);
        rez.add();
        rez.push(55.6);
        rez.push(12.1);
        rez.sub();
        rez.div();
        rez.push(19);
        rez.push(3.33);        //(737.22+24)/(55.6-12.1)+(19-3.33)*(87+2*(13.001-9.2)), используя класс StackCalc
        rez.sub();
        rez.push(87);
        rez.push(2);
        rez.push(13.001);
        rez.push(9.2);
        rez.sub();
        rez.mul();
        rez.add();
        rez.mul();
        rez.add();
        return rez.pop();
    }

    public static void main(String[] args) {
        System.out.println(calculation1());
        System.out.println(calculation2());
    }
}


