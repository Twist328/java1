package ru.progwards.java1.lessons.sets;

/*    Напишите метод с сигнатурой String figDetect(Figure fig), который
 - для квадрата возвращает "Сторона квадрата "+.side
- для круга возвращает "Диаметр круга "+.diameter
- для всех остальных классов "Неизвестная фигура"*/

public class Figure {

     static String figDetect(Figure fig) {
         if (fig == null) {
             return "Неизвестная фигура";
         }else if (fig.getClass().equals( Square.class)) {
             return "Сторона квадрата " + ((Square) fig).getSide();
         } else if (fig.getClass().equals(Round.class)) {
             return "Диаметр круга " + ((Round) fig).getDiameter();
         } else
        return "Неизвестная фигура";
    }

    static class Square extends Figure {
        private double side=10.0;

        public Square(double side) {
            this.side = side;
        }

        public Square() {

        }

        public double getSide() {
            return side;
        }
    }

    static class Round extends Figure {
        private double diameter;

        public Round(double diameter) {
            this.diameter = diameter;
        }

        public Round() {

        }

        public double getDiameter() {
            return diameter;
        }
    }
        public static void main(String[] args) {

            System.out.println(new Figure().figDetect(new Figure()));
            System.out.println(new Figure().figDetect(new Square(5.0)));
            System.out.println(new Figure().figDetect(new Round(12.0)));
            System.out.println(new Figure().figDetect(null));


        }
    }


