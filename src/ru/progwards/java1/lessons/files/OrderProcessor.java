package ru.progwards.java1.lessons.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class OrderProcessor {

/*
Информация о заказах поступает в виде файлов, которые лежат в под-папках разбитых по неделям,
имена папок не имеют значения. Имя каждого файла имеет формат: AAA-999999-ZZZZ.csv
где AAA - обязательные 3 символа shopId - идентификатор магазина,
999999 - обязательные 6 символов orderId - номер заказа,
ZZZZ - обязательные 4 символа customerId - идентификатор покупателя,
расширение файла - csv, например S02-P01X12-0012.csv: shopId=”S02”, orderId=”P01X12”, customerId=”0012”
Содержимое каждого файла имеет формат CSV (Comma Separated Values) со следующими данными
Наименование товара, количество, цена за единицу
Например:
Игрушка мягкая “Мишка”, 1, 1500
Пазл “Замок в лесу”, 2, 700
Книжка “Сказки Пушкина”, 1, 300
*/

    Path loadPath; // начальная папка для хранения файлов
    List<Order> orders; // список заказов
    String loadShop; // загруженный магазин

    // инициализирует класс, с указанием начальной папки для хранения файлов

    public OrderProcessor(String loadPath) {
        this.loadPath = Paths.get(loadPath);
    }

    // загружает заказы за указанный диапазон дат, с start до finish, обе даты включительно.
    // Если start == null, значит нет ограничения по дате слева, если finish == null, значит нет ограничения по дате справа,
    // если shopId == null - грузим для всех магазинов
    // При наличии хотя бы одной ошибки в формате файла, файл полностью игнорируется, т.е. Не поступает в обработку.
    // Метод возвращает количество файлов с ошибками. При этом, если в классе содержалась информация, ее надо удалить

    public int loadOrders(LocalDate start, LocalDate finish, String shopId) {
        orders = new ArrayList<Order>();
        int fFiles = 0;
        List<Path> paths = null;
        loadShop = shopId;

        // список файлов с информацией о заказах
        String filterID = shopId == null ? "???" : shopId;
        String pattern = "glob:**/" + filterID + "-??????-????.csv";
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(pattern);
        try {
            paths = Files.walk(loadPath)
                    .filter(p -> {
                        if (matcher.matches(p)) {
                            if (start == null && finish == null) return true;
                            LocalDate ld = getFileLocalDateTime(p).toLocalDate();
                            if (ld == null) return false;
                            return !((start != null && ld.isBefore(start)) || (finish != null && ld.isAfter(finish)));
                        }
                        return false;
                    })
                    .sorted(Comparator.comparing(this::getFileLocalDateTime))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (paths == null) return 0;
        //System.out.println(paths);

        for (Path path : paths) {
            if (!loadOrderFile(path)) {
                fFiles++;
                System.out.println("Processing failed: " + path);
            } else {
                System.out.println("Ok: " + path);
            }
        }
        //System.out.println(orders);
        return fFiles;
    }

    public LocalDateTime getFileLocalDateTime(Path path) {
        try {
            return LocalDateTime.ofInstant(Files.getLastModifiedTime(path).toInstant(), ZoneId.systemDefault());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // При загрузке Ордера в случае ошибки получаем false Ордер в корзину
    public boolean loadOrderFile(Path path) {
        Order order = new Order();
        Double sum = 0D;
        final String dell = ",";
        Charset set = Charset.forName("UTF-8");
        String fileName = path.getFileName().toString();
        try (BufferedReader reader = Files.newBufferedReader(path, set)) {
            String str;
            while ((str = reader.readLine()) != null) {
                try {
                    if (str.compareTo("") == 0) continue;
                    String[] anArray = str.split(dell);
                    if (anArray.length != 3) return false;
                    OrderItem item = new OrderItem();
                    item.googsName = anArray[0];
                    item.count = Integer.parseInt(anArray[1].trim());
                    item.price = Double.parseDouble(anArray[2].trim());
                    sum += item.price * item.count;
                    order.items.add(item);
                } catch (Exception e) {
                    System.err.println(fileName + ':' + str + ':' + e);
                    return false;
                }
            }
            String[] doArray = fileName.substring(0, fileName.lastIndexOf(".")).split("-");
            order.datetime = getFileLocalDateTime(path);
            order.shopId = doArray[0];
            order.orderId = doArray[1];
            if (doArray[1].length() != 6) return false;
            order.customerId = doArray[2];
            if (doArray[2].length() != 4) return false;
            order.sum = sum;
            Collections.sort(order.items, new Comparator<OrderItem>() {
                @Override
                public int compare(OrderItem o1, OrderItem o2) {
                    return o1.googsName.compareTo(o2.googsName);
                }
            });
            orders.add(order);
            return true;
        } catch (IOException e) {
            System.err.println(fileName + ':' + e);
        }
        return false;
    }

    // сортировка заказов
    void sortOrders() {
        Comparator<Order> dateTime = new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                return o1.datetime.compareTo(o2.datetime);
            }
        };
        Collections.sort(orders, dateTime);
    }

    // выдать список заказов в порядке обработки (отсортированные по дате-времени), для заданного магазина.
    // Если shopId == null, то для всех
    public List<Order> process(String shopId) {
        if (shopId == null || (loadShop != null && shopId.equals(loadShop))) return orders;
        List<Order> result = new ArrayList<Order>();
        for (Order o : orders) {
            if (o.shopId.equals(shopId)) result.add(o);
        }
        return result;
    }

    // cтатистика по объему продаж по магазинам (отсортированную по ключам): String - shopId, double - сумма стоимости всех проданных товаров в этом магазине
    public Map<String, Double> statisticsByShop() {
        Map<String, Double> res = new TreeMap<String, Double>();
        for (Order o : orders) {
            String key = o.shopId;
            boolean isExists = res.containsKey(key);
            double sum = isExists ? res.get(key) : 0;
            res.put(key, sum + o.sum);
        }
        return res;
    }

    // cтатистика по объему продаж по товарам (отсортированную по ключам): String - goodsName, double - сумма стоимости всех проданных товаров этого наименования
    public Map<String, Double> statisticsByGoods() {
        Map<String, Double> result = new TreeMap<String, Double>();
        for (Order o : orders) {
            for (OrderItem item : o.items) {
                String key = item.googsName;
                boolean isExists = result.containsKey(key);
                double sum = isExists ? result.get(key) : 0;
                result.put(key, sum + item.count * item.price);
            }
        }
        return result;
    }

    // cтатистика по объему продаж по дням (отсортированную по ключам): LocalDate - конкретный день, double - сумма стоимости всех проданных товаров в этот день
    public Map<LocalDate, Double> statisticsByDay() {
        Map<LocalDate, Double> result = new TreeMap<LocalDate, Double>();
        for (Order o : orders) {
            LocalDate key = o.datetime.toLocalDate();
            boolean isExists = result.containsKey(key);
            double sum = isExists ? result.get(key) : 0;
            result.put(key, sum + o.sum);
        }
        return result;
    }
}


