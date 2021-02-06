package ru.progwards.java1.lessons.abstractnum;

import java.io.IOException;

/*
3.3 Реализовать класс Cube, переопределяющий метод
public Number volume(), который будет возвращать объем куба по формуле Segment*Segment*Segment;
*/
public class Cube extends Figure3D {

    public Cube(Number segment) {
        super(segment);
    }

    public Number volume() throws IOException {
        return segment.mul(segment.mul(segment));
    }

}


