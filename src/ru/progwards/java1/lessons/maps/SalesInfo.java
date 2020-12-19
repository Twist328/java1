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
    // загрузить заказы из CSV файла: String, String, int, double

    public static int loadOrders(String fileName) {

        GOODS = new TreeMap<String, Double>();

        CONSUMERS = new TreeMap<String, AbstractMap.SimpleEntry<Double, Integer>>();

        int result = 0;

        try (FileReader r = new FileReader(fileName);
             Scanner s = new Scanner(r)) {

            while (s.hasNext()) {

                result += processLine(s.nextLine());

            }

        } catch (IOException e) {

            throw new RuntimeException(fileName + ":\n" + e.getMessage());

        }

        return result;

    }

    // загрузить содержимое строки, вернем количество успешно загруженных заказов

    private static int processLine(String str) {

        String[] words = str.split(",");

        if (words.length == 4) {

            try {

                String fio = words[0].trim();

                String good = words[1].trim();

                int cnt = Integer.parseInt(words[2].trim());

                double sum = Double.parseDouble(words[3].trim());

                //System.out.println(str);

                //В String - наименование товара, в Double - общая сумма продаж по товару

                GOODS.put(good, GOODS.containsKey(good) ? GOODS.get(good) + sum : sum);

                //В String  - ФИ, в Double - сумма всех покупок покупателя, в Integer - количество покупок

                if (CONSUMERS.containsKey(fio)) {

                    AbstractMap.SimpleEntry<Double, Integer> simpleEntry = CONSUMERS.get(fio);

                    sum += simpleEntry.getKey();

                    cnt += simpleEntry.getValue();

                }

                CONSUMERS.put(fio, new AbstractMap.SimpleEntry<Double, Integer>(sum, cnt));

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

        loadOrders("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\SalesInfo.java");

        System.out.println(getGoods());

        System.out.println(getCustomers());

    }

}