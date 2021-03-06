package Goon;

public class Figure {
    String figDetect(Figure fig) {

        if (fig == null) return "Неизвестная фигура";
        if (fig.getClass() == Square.class) return "Сторона квадрата " + ((Square) fig).getSide();
        if (fig.getClass() == Round.class) return "Диаметр круга " +((Round) fig).getDiameter();
        return "Неизвестная фигура";
    }
}
//Напишите метод с сигнатурой String figDetect(Figure fig), который
//
// - для квадрата возвращает "Сторона квадрата "+.side
//
//- для круга возвращает "Диаметр круга "+.diameter
//
//- для всех остальных классов "Неизвестная фигура"*/
    class Square extends Figure {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public double getSide() {
            return side;
        }
    }

    class Round extends Figure {
        private double diameter;

        public Round(double diameter) {
            this.diameter = diameter;
        }

        public double getDiameter() {
            return diameter;
        }
    }

