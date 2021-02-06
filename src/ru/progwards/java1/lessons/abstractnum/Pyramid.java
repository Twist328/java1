package ru.progwards.java1.lessons.abstractnum;

import com.google.common.math.IntMath;

/*
Реализовать класс Pyramid, переопределяющий метод
public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат, и высотой равной стороне
 квадрата по формуле Segment*Segment*Segment/3;
*/
public class Pyramid extends Figure3D {

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

        return segment.mul(segment.mul(segment).div(new IntNumber(Math.abs(3))));
    }
}


