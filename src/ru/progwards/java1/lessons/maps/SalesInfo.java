package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SalesInfo {

    private static Map<String, Double> GOODS;
    private static Map<String, AbstractMap.SimpleEntry<Double, Integer>> CONSUMERS;

    public static int loadOrders(String fileName) {     // загрузить заказы из CSV файла: String, String, int, double

        GOODS = new TreeMap<String, Double>();
        CONSUMERS = new TreeMap<String, AbstractMap.SimpleEntry<Double, Integer>>();
        int res = 0;
        try (FileReader reader = new FileReader(fileName);
             Scanner scan = new Scanner(reader)) {
            while (scan.hasNext()) {
                res += processLine(scan.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName + ":\n" + e.getMessage());
        }
        return res;
    }

    private static int processLine(String str) {// загрузить содержимое строки, вернем количество успешно загруженных заказов

        String[] words = str.split(",");
        if (words.length == 4) {
            try {
                String pers = words[0].trim();
                String good = words[1].trim();
                int count = Integer.parseInt(words[2].trim());
                double sum = Double.parseDouble(words[3].trim());
                //System.out.println(str);
                GOODS.put(good, GOODS.containsKey(good) ? GOODS.get(good) + sum : sum);    //В String - наименование товара, в Double - общая сумма продаж по товару
                if (CONSUMERS.containsKey(pers)) {   //В String  - ФИ, в Double - сумма всех покупок покупателя, в Integer - количество покупок
                    AbstractMap.SimpleEntry<Double, Integer> simpleEntry = CONSUMERS.get(pers);
                    sum += simpleEntry.getKey();
                    count += simpleEntry.getValue();
                }
                CONSUMERS.put(pers, new AbstractMap.SimpleEntry<Double, Integer>(sum, count));
                return 1;
            } catch (Exception e) {

            }
        }
        return 0;
    }

    public static Map<String, Double> getGoods() {
        return GOODS;
    }

    public static Map<String, AbstractMap.SimpleEntry<Double, Integer>> getCustomers() {
        return CONSUMERS;
    }
    public static void main(String[] args) {

        loadOrders("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\SalesINFO");

        System.out.println(getGoods());
        System.out.println(getCustomers());

    }

}