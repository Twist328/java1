package ru.progwards.java1.lessons.abstractnum;


//import ru.progwards.java1.lessons.bigints.IntInteger;

/*
Реализовать класс Pyramid, переопределяющий метод
public Number volume(), который будет возвращать объем пирамиды, с основанием квадрат, и высотой равной стороне
 квадрата по формуле Segment*Segment*Segment/3;
*/
public class Pyramid extends Figure3D {
    public Number volume(){
        return segment.mul(segment.mul(segment)).div(super.segment);
    }
    public Pyramid() {
    }
}


