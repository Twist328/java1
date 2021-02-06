package ru.progwards.java1.lessons.abstractnum;


import javassist.expr.Instanceof;

/*
Реализовать класс Pyramid, переопределяющий метод
public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат, и высотой равной стороне
 квадрата по формуле Segment*Segment*Segment/3;
*/
public class Pyramid extends Figure3D {
    Double DoubleNumber;
    @Override
    public String toString() {
        return "Pyramid{" +
                "volume=" + segment +
                '}';
    }

    public Pyramid(Number segment) {
        super(segment);

    }

    public Number volume(){
        DoubleNumber dn = new DoubleNumber(3.0);
        return segment.mul(segment.mul(segment).div(new IntNumber(3)));
    }
}


