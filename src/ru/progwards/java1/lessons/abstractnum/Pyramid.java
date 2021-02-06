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
        this.segment = segment;
    }


    @Override
    public Number volume() {
        return segment.mul(segment.mul(segment).div(segment));


    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "segment=" + segment +
                '}';
    }
}
