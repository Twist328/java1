package ru.progwards.java1.lessons.files;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Test17 {
    public static void main(String[] args) throws IOException {

        OrderProcessor OP = new OrderProcessor("C:/Projects/java1/src/ru/progwards/java1/lessons/files/AAA-999999-ZZZZ.csv");
        System.out.println(OP.loadOrders(LocalDate.of(2021, Month.JANUARY, 13), null, null));
        System.out.println(OP.loadOrders(null, null, null));
        System.out.println(OP.process(null));
        System.out.println(OP.statisticsByShop());

        OrderProcessor OP1 = new OrderProcessor("C:/Projects/java1/src/ru/progwards/java1/lessons/files/S02-P01X12-0012.csv");
        System.out.println(OP1.loadOrders(LocalDate.of(2021, Month.JANUARY, 13), null, null));
        System.out.println(OP1.loadOrders(null, null, null));
        System.out.println(OP1.process(null));
        System.out.println(OP1.statisticsByShop());
    }
}

