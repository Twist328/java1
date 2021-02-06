package ru.progwards.java1.lessons.abstractnum;


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

        return segment.mul(segment.mul(segment).div(new IntNumber(3)));//еще Вариант .div(segment.newNumber("3")));
        //если прописать в newNumber("3.0"))) будет ошибка . Также не хочет вариант с .div(new DoubleNumber(3.0)))
        // Вот в сданном варианте не принимается задача именно класс Pyramid, неточность в результате копеечная, НАПРИМЕР:
        // "Возвращен результат: 4055590, ожидался: 4055666""          ЧТО СДЕЛАТЬ???
    }
}


