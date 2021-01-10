package ru.progwards.java1.lessons.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class Order {
    public String shopId; // идентификатор магазина
    public String orderId; // идентификатор заказа
    public String customerId; // идентификатор покупателя
    public LocalDateTime datetime; // дата-время заказа (из атрибутов файла - дата последнего изменения)
    public List<OrderItem> items; // список позиций в заказе, отсортированный по наименованию товара
    public double sum; // сумма стоимости всех позиций в заказе

    public Order() {
        items = new ArrayList<OrderItem>();
    }

    @Override
    public String toString() {
        return "Order{" +
                "shopId='" + shopId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", datetime=" + datetime +
                ", items=" + items +
                ", sum=" + sum +
                '}';
    }
}


