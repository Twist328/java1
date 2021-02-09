package ru.progwards.java1.lessons.abstractnum;


/*
Реализовать класс Pyramid, переопределяющий метод
public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат, и высотой равной стороне
 квадрата по формуле Segment*Segment*Segment/3;
*/
public class Pyramid extends Figure3D {

    public Pyramid(Number segment) {
        super(segment);

    }

    public Number volume(){

        return segment.mul(segment.mul(segment).div(segment.newNumber("3")));
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "segment=" + segment +
                '}';
    }
}

