package ru.progwards.java1.lessons.sets;


import java.util.*;

class Product {

    private String code; //уникальный артикул товара
    public Product(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return code;
    }
}
class Shop {

    private List<Product> products; //товары имеющиеся в магазине
    public Shop(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
}

public class ProductAnalytics {

    private List<Shop> shops; //список магазинов
    private List<Product> bestproducts; //список всех товаров

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.bestproducts = products;

    }

    public Set<Product> existInAll() {
        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<>();
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Set<Product> res = new HashSet<Product>(bestproducts);
        Iterator it = shops.iterator();
        while (it.hasNext()) {
            res.retainAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return res;
    }

    public Set<Product> existAtListInOne() {

        if (shops == null || shops.size() == 0) return new HashSet<>();
        Iterator it = shops.iterator();
        Set<Product> products = new HashSet<Product>(((Shop) it.next()).getProducts());
        while (it.hasNext()) {
            products.addAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        products.retainAll(products);
        return products;

    }

    public  Set<Product> notExistInShops() {//товары из products, которых нет ни в одном магазине

        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<>();
        Set<Product> res = new HashSet<Product>(bestproducts);
        if (shops == null || shops.size() == 0) return res;
        Iterator it = shops.iterator();
        while (it.hasNext()) {
            res.removeAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        return res;

    }

    public Set<Product> existOnlyInOne() {
        Set<Product> products = new HashSet<Product>();
        if (bestproducts == null || bestproducts.size() == 0) return products;
        if (shops == null || shops.size() == 0) return products;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> res1 = new HashSet<Product>();
            Set<Product> res2;
            Set<Product> res3 = new HashSet<Product>();
            Iterator it = shops.iterator();
            for (int j = 0; j < shops.size(); j++) {
                res2 = new HashSet<Product>(((Shop) it.next()).getProducts());
                res2.retainAll(bestproducts);
                if (j < i) {
                    res3.addAll(res2);
                } else if (j == i) {
                     res1 = res2;
                     res1.removeAll(res3);
                } else {
                    res1.removeAll(res2);
                }
            }
            products.addAll(res1);
        }

        return products;
    }

    public static void main(String[] args) {

        Set<Product> products = new HashSet<Product>();


       // System.out.println(existInAll());
       // System.out.println(notExistInShops());

    }
}