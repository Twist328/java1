package ru.progwards.java1.lessons.abstractnum;
/*
Реализовать класс Pyramid, переопределяющий метод
public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат, и высотой равной стороне
 квадрата по формуле Segment*Segment*Segment/3;
*/
public class Pyramid extends Figure3D {
    public Pyramid() {
        super();
    }

    public Pyramid(Number segment) {
        super(segment);
    }
    @Override
    public Number volume() {
        Number result=segment.mul(segment).mul(segment);
        return   result.div(3);

    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "segment=" + segment +
                '}';
    }
}
