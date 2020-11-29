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
        Set<Product> products = new HashSet<Product>(bestproducts);
        Iterator it = shops.iterator();
        while (it.hasNext()) {
            products.retainAll(new HashSet<Product>(((Shop) it.next()).getProducts()));
        }
        return products;
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

        Set<Product> products= new HashSet<Product>(bestproducts);//*

        if (shops == null || shops.size() == 0) return products;

        Iterator it = shops.iterator();

        while (it.hasNext()) {

            products.removeAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        return products;

    }

    public Set<Product> existOnlyInOne() {
        Set<Product> products = new HashSet<Product>();
        if (bestproducts == null || bestproducts.size() == 0) return products;
        if (shops == null || shops.size() == 0) return products;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> productsBefore = new HashSet<Product>();
            Set<Product> products1 = new HashSet<Product>();
            Set<Product> products2;
            Iterator it = shops.iterator();
            for (int j = 0; j < shops.size(); j++) {
                products2 = new HashSet<Product>(((Shop) it.next()).getProducts());
                products2.retainAll(bestproducts);
                if (j < i) {
                    productsBefore.addAll(products2);
                } else if (j == i) {
                    products1 = products2;
                    products1.removeAll(productsBefore);
                } else {
                    products1.removeAll(products2);
                }
            }
            products.addAll(products1);
        }

        return products;
    }


    public static void main(String[] args) {

        Set<Product> products = new HashSet<Product>();


       // System.out.println(existInAll());
       // System.out.println(notExistInShops());

    }
}