package Tvist823Tests;

class Person {
    static class Child1 {                     //Создайте класс Tvist823Tests.Person, а внутри него 2 класса

        String hello() {                       // вложенный класс Child1
            return "привет";                   //  внутренний класс Child2
        }
    }                                          //  У каждого класса, Child1 и Child2 создайте метод String hello()

                                               //  У Child1 String hello() должен вернуть "привет"
                                               // У Child2 String hello() должен вернуть "servus"

        class Child2 {
            String hello() {
                return "servus";
            }
        }
    }
